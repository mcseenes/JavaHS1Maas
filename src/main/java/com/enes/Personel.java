package com.enes;

import java.util.UUID;

public abstract class Personel {
    public String ad;
    public String pozisyon;
    private int CalismaSaati;

    public Personel(String ad, String pozisyon, int calismaSaati) {
        this.ad = ad;
        this.pozisyon = pozisyon;
        CalismaSaati = calismaSaati;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public int getCalismaSaati() {
        return CalismaSaati;
    }

    public void setCalismaSaati(int calismaSaati) {
        CalismaSaati = calismaSaati;
    }

    // Yönetici için maaş hesaplama
    public abstract double maasHesapla(int calismaSaati);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Personel{");
        sb.append("ad='").append(ad).append('\'');
        sb.append(", pozisyon='").append(pozisyon).append('\'');
        sb.append(", CalismaSaati=").append(CalismaSaati);
        sb.append(", calismaSaati=").append(getCalismaSaati());
        sb.append('}');
        return sb.toString();
    }
}
