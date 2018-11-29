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
    //TODO
    private final Long idempresa = 98L;
    private int veces;

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
        } catch (Exception o) {
            System.out.println(o.getMessage());
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
                System.out.println(exp.getMessage());
                userTransaction.rollback();
            }
        }
    }

    @Lock(LockType.WRITE)
    protected void migrarManzanas(List<Manzana> manzanas) throws Exception {
        for (Manzana manzana : manzanas) {
            List<GiManzanaView> giManzanas = em.createQuery("select o from GiManzanaView o "
                    + " where o.idempresa = :idempresa "
                    + " and o.giFraccion = :fraccion "
                    + " and o.codigo = :manzana", GiManzanaView.class)
                    .setParameter("idempresa", idempresa)
                    .setParameter("fraccion", Long.parseLong(manzana.getIdFraccion().toString()))
                    .setParameter("manzana", manzana.getIdManzana().toString())
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
                    giManzana.setCodigo(manzana.getIdManzana().toString());
                    giManzana.setGiFraccion(giFraccion);
                    giManzana.setLotesCnt(Long.parseLong(manzana.getCantidadLotes().toString()));

                    em.merge(giManzana);
                }
                userTransaction.commit();
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
                userTransaction.rollback();
            }
        }
    }

    @Lock(LockType.WRITE)
    protected void migrarLotes(List<Lote> lotes) throws Exception {
        for (Lote lote : lotes) {
            //Buscar en gi_fraccion
            List<GiLoteView> giLotes = em.createQuery("select o from GiLoteView o "
                    + " where o.idempresa = :idempresa "
                    + " and o.giFraccion = :fraccion "
                    + " and o.giManzana = :manzana "
                    + " and o.codigo = :lote ", GiLoteView.class)
                    .setParameter("idempresa", idempresa)
                    .setParameter("fraccion", Long.parseLong(lote.getIdFraccion().toString()))
                    .setParameter("manzana", lote.getIdManzana().toString())
                    .setParameter("lote", lote.getIdLote().toString())
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
                            .setParameter("gimanzana", lote.getIdManzana().toString())
                            .getSingleResult();

                    giLote = new GiLote();
                    giLote.setIdgiLote(0L);
                    giLote.setCodigo(lote.getIdLote().toString());
                    GiLoteestado giLoteEstado = em.find(GiLoteestado.class, getLoteEstado(lote));
                    giLote.setIdgiLoteestado(giLoteEstado);
                    Moneda moneda = em.createQuery("select o from Moneda o where o.idempresa = :idempresa and o.codigo = :codigo", Moneda.class)
                            .setParameter("idempresa", idempresa)
                            .setParameter("codigo", lote.getIdMoneda())
                            .getSingleResult();
                    GiManzana giManzana = em.find(GiManzana.class, giManzanaView.getIdgiManzana());
                    giLote.setGiManzana(giManzana);

                    giLote.setCuotasCnt(lote.getPlazo());
                    giLote.setIdmoneda(moneda);
                    giLote.setTipo(getLoteTipo(lote));
                } else {
                    giLote = em.find(GiLote.class, giLotes.get(0).getIdgiLote());
                }
                giLote.setPreciocosto(BigDecimal.ZERO);
                giLote.setPorcadminvtacontado(BigDecimal.ZERO);
                giLote.setImportecuota(lote.getMontoCuota().add(lote.getIvaCuota()));
                giLote.setImporteinicial(lote.getImporteEntregaInicial());
                giLote.setLinderoNorte(lote.getLinderoNorte());
                giLote.setLinderoSur(lote.getLinderoSur());
                giLote.setLinderoOeste(lote.getLinderoOeste());
                giLote.setLinderoEste(lote.getLinderoEste());
                giLote.setLongNorte(lote.getDimensionNorte());
                giLote.setLongSur(lote.getDimensionSur());
                giLote.setLongEste(lote.getDimensionEste());
                giLote.setLongOeste(lote.getDimensionOeste());
                giLote.setSuperficieM2(lote.getDimension());
                giLote.setNroctactecatastral(lote.getCtaCteCtral());
                giLote.setPreciovtacontado(lote.getPrecioContado());
                em.merge(giLote);
                userTransaction.commit();
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
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
}