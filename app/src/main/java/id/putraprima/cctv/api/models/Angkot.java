package id.putraprima.cctv.api.models;

public class Angkot {
    public int id;
    public String name;
    public String rute;
    public String peta;


    public Angkot() {
    }

    public Angkot(int id, String name, String rute, String peta) {
        this.id = id;
        this.name = name;
        this.rute = rute;
        this.peta = peta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public String getPeta() {
        return peta;
    }

    public void setPeta(String peta) {
        this.peta = peta;
    }
}
