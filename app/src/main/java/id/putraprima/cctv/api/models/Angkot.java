package id.putraprima.cctv.api.models;

public class Angkot {
    public int id;
    public String nama;
    public String rute;
    public String peta;

    public Angkot() {
    }

    public Angkot(int id, String nama, String rute, String peta) {
        this.id = id;
        this.nama = nama;
        this.rute = rute;
        this.peta = peta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
