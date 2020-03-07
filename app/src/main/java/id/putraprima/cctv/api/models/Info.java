package id.putraprima.cctv.api.models;

public class Info {
    public String judul,pengumuman;

    public Info(String judul, String pengumuman) {
        this.judul = judul;
        this.pengumuman = pengumuman;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengumuman() {
        return pengumuman;
    }

    public void setPengumuman(String pengumuman) {
        this.pengumuman = pengumuman;
    }
}

