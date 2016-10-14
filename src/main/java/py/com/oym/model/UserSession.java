package py.com.oym.model;

import java.util.Date;

public class UserSession {
    private String user;
    private Date timeLogin = new Date();
    private Long  idempresa;
    private Long  idvendedor;
    private String ip;
    private String host;
    private String persistenceUnit;
    private String sessionId;
    private Date   lastReference = new Date();

    public UserSession() {
    }

    public UserSession(String user, String ip, String host, String persistenceUnit, String sessionId) {
        this.user = user;
        this.ip = ip;
        this.host = host;
        this.persistenceUnit = persistenceUnit;
        this.sessionId = sessionId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(Date timeLogin) {
        this.timeLogin = timeLogin;
    }
    
    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }
    
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPersistenceUnit() {
        return persistenceUnit;
    }

    public void setPersistenceUnit(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }    

    public Date getLastReference() {
        return lastReference;
    }

    public void setLastReference(Date date) {
        this.lastReference = date;
    }
    
}
