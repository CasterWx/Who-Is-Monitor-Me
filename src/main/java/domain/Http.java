package domain;

import java.util.Date;

public class Http {

    private long id ;
    private String hostname ;
    private String ip ;
    private String address ;
    private String date ;

    @Override
    public String toString() {
        return "Http{" +
                "id=" + id +
                ", hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
