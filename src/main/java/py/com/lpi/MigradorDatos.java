/*
* Copyright (c) 2015-2017 OyM System Group S.A.
* Capitan Cristaldo 464, Asunción, Paraguay
* All rights reserved. 
*
* NOTICE:  All information contained herein is, and remains
* the property of OyM System Group S.A. and its suppliers,
* if any.  The intellectual and technical concepts contained
* herein are proprietary to OyM System Group S.A.
* and its suppliers and protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material
* is strictly forbidden unless prior written permission is obtained
* from OyM System Group S.A.
 */
package py.com.lpi;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.apache.log4j.Logger;
import py.com.oym.model.tables.GiFraccion;
import py.com.oym.model.tables.GiLote;
import py.com.oym.model.tables.GiLoteestado;
import py.com.oym.model.tables.GiManzana;
import py.com.oym.model.tables.Moneda;
import py.com.oym.model.views.GiLoteView;
import py.com.oym.model.views.GiManzanaView;

@Singleton
@Startup
@Lock(LockType.READ)
@TransactionManagement(TransactionManagementType.BEAN)
public class MigradorDatos {

    private static final Logger LOGGER = Logger.getLogger(MigradorDatos.class);
    private final Long idempresa = 50L;
    private Long veces = 0L;

    @PersistenceContext(unitName = "maker95PU")
    private EntityManager em;

    @PersistenceContext(unitName = "lpiPU")
    private EntityManager em2;

    @Resource
    private UserTransaction userTransaction;

    //Todo cambiar a */10 en minute
    @Schedule(minute = "*", hour = "*", info = "OcrExecutor", persistent = false)
    @Lock(LockType.WRITE)
    @AccessTimeout(value = 10, unit = TimeUnit.MINUTES)
    protected void execute(Timer timer) {
        veces++;
        LOGGER.info("Executing ..." + veces);
        LOGGER.info("Execution Time : " + new Date());
        LOGGER.info("Next Execution Time : " + timer.getNextTimeout());
        LOGGER.info("Time remaining: " + timer.getTimeRemaining());
        LOGGER.info("____________________________________________");

        try {
            List<Fraccion> fracciones = em2.createQuery("select o from Fraccion o order by o.idFraccion", Fraccion.class).getResultList();
            migrarFracciones(fracciones);
            List<Manzana> manzanas = em2.createQuery("select o from Manzana o order by o.idFraccion, o.idManzana", Manzana.class).getResultList();
            migrarManzanas(manzanas);
            List<Lote> lotes = em2.createQuery("select o from Lote o order by o.idFraccion, o.idManzana, o.idLote", Lote.class).getResultList();
            migrarLotes(lotes);
            // Eliminar de maker lo que no existe en lpi
            if (veces % 10 == 0){
                eliminarLotes();
                eliminarManzanas();
                eliminarFracciones(fracciones);
            }
        } catch (Exception exp) {
            LOGGER.error(exp);
        }
        if (veces >= 1000000){
            veces = 0L;
        }
    }

    protected void migrarFracciones(List<Fraccion> fracciones) throws Exception {
        for (Fraccion fraccion : fracciones) {
            //Buscar en gi_fraccion
            List<GiFraccion> giFracciones = em.createQuery("select o from GiFraccion o where o.idempresa = :idempresa and o.codigo = :codigo", GiFraccion.class)
                    .setParameter("idempresa", idempresa)
                    .setParameter("codigo", Long.parseLong(fraccion.getIdFraccion().toString()))
                    .getResultList();
            userTransaction.begin();
            try {
                GiFraccion giFraccion;
                if (giFracciones.isEmpty()) {
                    giFraccion = new GiFraccion();
                    giFraccion.setIdgiFraccion(0L);
                    giFraccion.setIdempresa(idempresa);
                    giFraccion.setCodigo(fraccion.getIdFraccion());
                    giFraccion.setSuperficieM2(BigDecimal.ZERO);
                } else {
                    giFraccion = giFracciones.get(0);
                }
                int len = 49;
                if (fraccion.getDescripcion().length() < 49) {
                    len = fraccion.getDescripcion().length();
                }
                giFraccion.setNombre(fraccion.getDescripcion().substring(0, len));
                em.merge(giFraccion);
                userTransaction.commit();
            } catch (Exception exp) {
                LOGGER.error(exp);                
                userTransaction.rollback();
            }
        }
    }

    @Lock(LockType.WRITE)
    protected void migrarManzanas(List<Manzana> manzanas) throws Exception {
        for (Manzana manzana : manzanas) {
            String manzanaCodigo = manzana.getIdManzana().toString();
            manzanaCodigo = mask(manzanaCodigo, 3, "0");

            List<GiManzanaView> giManzanas = em.createQuery("select o from GiManzanaView o "
                    + " where o.idempresa = :idempresa "
                    + " and o.giFraccion = :fraccion "
                    + " and o.codigo = :manzana", GiManzanaView.class)
                    .setParameter("idempresa", idempresa)
                    .setParameter("fraccion", Long.parseLong(manzana.getIdFraccion().toString()))
                    .setParameter("manzana", manzanaCodigo)
                    .getResultList();
            userTransaction.begin();
            try {
                if (giManzanas.isEmpty()) {
                    GiFraccion giFraccion = em.createQuery("select o from GiFraccion o where o.idempresa = :idempresa and o.codigo = :codigo", GiFraccion.class)
                            .setParameter("idempresa", idempresa)
                            .setParameter("codigo", Long.parseLong(manzana.getIdFraccion().toString()))
                            .getSingleResult();

                    GiManzana giManzana = new GiManzana();
                    giManzana.setIdgiManzana(0L);
                    giManzana.setCodigo(manzanaCodigo);
                    giManzana.setGiFraccion(giFraccion);
                    giManzana.setLotesCnt(Long.parseLong(manzana.getCantidadLotes().toString()));

                    em.merge(giManzana);
                }
                userTransaction.commit();
            } catch (Exception exp) {
                LOGGER.error(exp);                
                userTransaction.rollback();
            }
        }
    }

    @Lock(LockType.WRITE)
    protected void migrarLotes(List<Lote> lotes) throws Exception {
        for (Lote lote : lotes) {
            String manzanaCodigo = lote.getIdManzana().toString();
            manzanaCodigo = mask(manzanaCodigo, 3, "0");
            String loteCodigo = lote.getIdLote().toString();
            loteCodigo = mask(loteCodigo, 3, "0");
            //Buscar en gi_fraccion
            List<GiLoteView> giLotes = em.createQuery("select o from GiLoteView o "
                    + " where o.idempresa = :idempresa "
                    + " and o.giFraccion = :fraccion "
                    + " and o.giManzana = :manzana "
                    + " and o.codigo = :lote ", GiLoteView.class)
                    .setParameter("idempresa", idempresa)
                    .setParameter("fraccion", Long.parseLong(lote.getIdFraccion().toString()))
                    .setParameter("manzana", manzanaCodigo)
                    .setParameter("lote", loteCodigo)
                    .getResultList();
            userTransaction.begin();
            try {
                GiLote giLote;
                if (giLotes.isEmpty()) {
                    GiManzanaView giManzanaView = em.createQuery("select o from GiManzanaView o "
                            + " where o.idempresa = :idempresa "
                            + " and o.giFraccion = :gifraccion "
                            + " and o.codigo = :gimanzana ", GiManzanaView.class)
                            .setParameter("idempresa", idempresa)
                            .setParameter("gifraccion", Long.parseLong(lote.getIdFraccion().toString()))
                            .setParameter("gimanzana", manzanaCodigo)
                            .getSingleResult();

                    giLote = new GiLote();
                    giLote.setIdgiLote(0L);
                    giLote.setCodigo(loteCodigo);
                    GiLoteestado giLoteEstado = em.find(GiLoteestado.class, getLoteEstado(lote));
                    giLote.setIdgiLoteestado(giLoteEstado);
                    String monedaCodigo = lote.getIdMoneda();
                    if (monedaCodigo == null || monedaCodigo.isEmpty()){
                        monedaCodigo = "GS";
                    }
                    Moneda moneda = em.createQuery("select o from Moneda o where o.idempresa = :idempresa and o.codigo = :codigo", Moneda.class)
                            .setParameter("idempresa", idempresa)
                            .setParameter("codigo", monedaCodigo)
                            .getSingleResult();
                    GiManzana giManzana = em.find(GiManzana.class, giManzanaView.getIdgiManzana());
                    giLote.setGiManzana(giManzana);

                    giLote.setCuotasCnt(nvl(lote.getPlazo(),Short.parseShort("0")));
                    giLote.setIdmoneda(moneda);
                    giLote.setTipo(getLoteTipo(lote));
                    giLote.setFechacambioestado(lote.getFechaEstado());
                    if ("A".equals(giLote.getIdgiLoteestado().getIdgiLoteestado())){
                        giLote.setFechareserva(lote.getFechaEstado());
                    }
                } else {
                    giLote = em.find(GiLote.class, giLotes.get(0).getIdgiLote());
                    // Si fecha de reserva es nulo o 
                    // Si hubo una reserva en la app de este lote y la fecha de cambio de estado en la base de lpi es posterior
                    if (giLote.getFechareserva() == null || giLote.getFechareserva().before(lote.getFechaEstado())){
                        GiLoteestado giLoteEstado = em.find(GiLoteestado.class, getLoteEstado(lote));
                        //Guardar el anterior estado
                        giLote.setIdgiLoteestadoAnt(giLote.getIdgiLoteestado().getIdgiLoteestado());
                        giLote.setIdgiLoteestado(giLoteEstado);
                        giLote.setFechacambioestado(lote.getFechaEstado());                        
                        if (giLote.getFechareserva() != null){
                            if ("A".equals(giLote.getIdgiLoteestado().getIdgiLoteestado())){
                                giLote.setFechareserva(lote.getFechaEstado());
                            }
                            else{
                                giLote.setIdvendedorreserva(null);                                
                                giLote.setFechareserva(null);
                            }
                        }
                    }
                }
                giLote.setPreciocosto(BigDecimal.ZERO);
                giLote.setPorcadminvtacontado(BigDecimal.ZERO);
                giLote.setImportecuota(nvl(lote.getMontoCuota().add(lote.getIvaCuota()),BigDecimal.ZERO));
                giLote.setImporteinicial(nvl(lote.getImporteEntregaInicial(),BigDecimal.ZERO));
                giLote.setLinderoNorte(lote.getLinderoNorte());
                giLote.setLinderoSur(lote.getLinderoSur());
                giLote.setLinderoOeste(lote.getLinderoOeste());
                giLote.setLinderoEste(lote.getLinderoEste());
                giLote.setLongNorte(lote.getDimensionNorte());
                giLote.setLongSur(lote.getDimensionSur());
                giLote.setLongEste(lote.getDimensionEste());
                giLote.setLongOeste(lote.getDimensionOeste());
                giLote.setSuperficieM2(lote.getDimension());
                giLote.setNroctactecatastral(nvl(lote.getCtaCteCtral(),""));
                giLote.setPreciovtacontado(nvl(lote.getPrecioContado(),BigDecimal.ZERO));
                em.merge(giLote);
                userTransaction.commit();
            } catch (Exception exp) {
                LOGGER.error(exp);
                userTransaction.rollback();
            }
        }
    }

    //TODO verificar
    protected Short getLoteTipo(Lote lote) {
        Short result = 1; // Lote normal.
        if ("H".equals(lote.getEstado())) {  //Plaza
            result = 2;
        } else if ("K".equals(lote.getEstado())) {  //Edificio o espacio público.
            result = 3;
        }
        return result;
    }

    //TODO verificar
    protected String getLoteEstado(Lote lote) {
        String result = "";
        switch (lote.getEstado()) {
            case "L": //Disponible
                result = "1";
                break;
            case "V": //Vendido
                result = "2";
                break;
            case "R": //Reserva vendedor
                result = "A";
                break;
            case "A": //Bloqueado
                result = "7";
                break;
            case "B": //Bloqueado
                result = "7";
                break;
            case "C": //Cancelado
                result = "9";
                break;
            case "X": //Cancelado
                result = "9";
                break;
            default: // Optional

        }
        return result;
    }

    protected void eliminarLotes() throws Exception {
        List<GiLoteView> giLotesView = em.createQuery("select o from GiLoteView o "
                + " where o.idempresa = :idempresa ", GiLoteView.class)
                .setParameter("idempresa", idempresa)
                .getResultList();
        for (GiLoteView giLoteView : giLotesView) {
            boolean noExiste;
            try {
                noExiste = !buscarLote(giLoteView.getGiFraccion(), giLoteView.getGiManzana(), giLoteView.getCodigo());
                if (noExiste) {
                    userTransaction.begin();
                    GiLote giLote = em.find(GiLote.class, giLoteView.getIdgiLote());
                    em.remove(em.merge(giLote));
                    userTransaction.commit();
                }
            } catch (Exception exp) {
                LOGGER.error(exp);
                userTransaction.rollback();
            }
        }
    }

    protected void eliminarManzanas() throws Exception {
        List<GiManzanaView> giManzanasView = em.createQuery("select o from GiManzanaView o "
                + " where o.idempresa = :idempresa ", GiManzanaView.class)
                .setParameter("idempresa", idempresa)
                .getResultList();
        for (GiManzanaView giManzanaView : giManzanasView) {
            boolean noExiste;
            try {
                noExiste = !buscarManzana(giManzanaView.getGiFraccion(), giManzanaView.getCodigo());
                if (noExiste) {
                    userTransaction.begin();
                    GiManzana giManzana = em.find(GiManzana.class, giManzanaView.getIdgiManzana());
                    em.remove(em.merge(giManzana));
                    userTransaction.commit();
                }
            } catch (Exception exp) {
                LOGGER.error(exp);
                userTransaction.rollback();
            }
        }
    }

    protected void eliminarFracciones(List<Fraccion> fracciones) throws Exception {
        List<GiFraccion> giFracciones = em.createQuery("select o from GiFraccion o "
                + " where o.idempresa = :idempresa ", GiFraccion.class)
                .setParameter("idempresa", idempresa)
                .getResultList();
        for (GiFraccion giFraccion : giFracciones) {
            boolean noExiste;
            try {
                noExiste = !buscarFraccion(fracciones, giFraccion.getCodigo());
                if (noExiste) {
                    userTransaction.begin();
                    em.remove(em.merge(giFraccion));
                    userTransaction.commit();
                }
            } catch (Exception exp) {
                LOGGER.error(exp);
                userTransaction.rollback();
            }
        }
    }

    protected boolean buscarFraccion(List<Fraccion> fracciones, Long fraccionCodigo) {
        boolean existe = false;
        Integer fraccionCodigo2 = Integer.parseInt(fraccionCodigo.toString());
        for (Fraccion fraccion: fracciones){
            if (fraccion.getIdFraccion().equals(fraccionCodigo2)){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    protected boolean buscarManzana(Long fraccionCodigo, String manzanaCodigo) {
        Integer fraccionCodigo2 = Integer.parseInt(fraccionCodigo.toString());
        Integer manzanaCodigo2  = Integer.parseInt(manzanaCodigo.trim());
        List<Manzana> manzanas = em2.createQuery("select o from Manzana o "
                + "where o.idFraccion = :id_fraccion "
                + "and o.idManzana = :id_manzana ", Manzana.class)
                .setParameter("id_fraccion", fraccionCodigo2)
                .setParameter("id_manzana", manzanaCodigo2)
                .getResultList();
        return !manzanas.isEmpty();
    }

    protected boolean buscarLote(Long fraccionCodigo, String manzanaCodigo, String loteCodigo) {
        Integer fraccionCodigo2 = Integer.parseInt(fraccionCodigo.toString());
        Integer manzanaCodigo2  = Integer.parseInt(manzanaCodigo.trim());
        Integer loteCodigo2  = Integer.parseInt(loteCodigo.trim());
        List<Lote> lotes = em2.createQuery("select o from Lote o "
                + "where o.idFraccion = :id_fraccion "
                + "and o.idManzana = :id_manzana "
                + "and o.idLote = :id_lote", Lote.class)
                .setParameter("id_fraccion", fraccionCodigo2)
                .setParameter("id_manzana", manzanaCodigo2)
                .setParameter("id_lote", loteCodigo2)
                .getResultList();
        return !lotes.isEmpty();
    }

    protected String mask(String dato, int veces, String caracter) {
        if (dato == null) {
            return null;
        }
        veces = veces - dato.trim().length();
        String result = dato.trim();
        for (int i = 0; i < veces; i++) {
            result = caracter + result;
        }
        return result;
    }
    
    protected <T> T nvl(T valor, T valorReemplazo){
        if (valor == null){
            return valorReemplazo;
        }
        return valor;
    }
}
