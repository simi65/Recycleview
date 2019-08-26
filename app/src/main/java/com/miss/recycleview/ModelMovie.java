package com.miss.recycleview;

public class ModelMovie  {

    private String judul;
    private String subjudul;
    private int gambar;
    private int logo;


    public ModelMovie(String judul, String subjudul, int gambar, int logo) {
        this.judul = judul;
        this.subjudul = subjudul;
        this.gambar = gambar;
        this.logo = logo;
    }


    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSubjudul() {
        return subjudul;
    }

    public void setSubjudul(String subjudul) {
        this.subjudul = subjudul;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
