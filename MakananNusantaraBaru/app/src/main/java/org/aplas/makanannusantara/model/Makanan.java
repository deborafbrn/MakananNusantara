package org.aplas.makanannusantara.model;

public class Makanan {
    private String nama;
    private String foto;
    private String info;

    public Makanan(String foto, String nama, String info) {
        this.nama = nama;
        this.foto = foto;
        this.info = info;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
