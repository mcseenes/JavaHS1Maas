package com.enes;

public class Memur extends Personel{
    private double saatlikUcret;
    private int maxCalismaSaati = 180;
    private double mesaiUcretKatsayisi = 1.5;


    public Memur(String ad, String pozisyon, int calismaSaati) {
        super(ad, pozisyon, calismaSaati);
    }


    // com.enes.Memur için maaş hesaplama
    @Override
    public double maasHesapla(int calismaSaati) {
        double toplamMaas = 0;
        if (calismaSaati > maxCalismaSaati) {
            toplamMaas += (maxCalismaSaati * saatlikUcret) +
                    ((calismaSaati - maxCalismaSaati) * saatlikUcret * mesaiUcretKatsayisi);
        } else {
            toplamMaas += calismaSaati * saatlikUcret;
        }
        System.out.println("MAASINIZ="+toplamMaas);
        return toplamMaas;
    }

    public double getSaatlikUcret() {
        return saatlikUcret;
    }

    public void setSaatlikUcret(double saatlikUcret) {
        this.saatlikUcret = saatlikUcret;
    }

    public int getMaxCalismaSaati() {
        return maxCalismaSaati;
    }

    public void setMaxCalismaSaati(int maxCalismaSaati) {
        this.maxCalismaSaati = maxCalismaSaati;
    }

    public double getMesaiUcretKatsayisi() {
        return mesaiUcretKatsayisi;
    }

    public void setMesaiUcretKatsayisi(double mesaiUcretKatsayisi) {
        this.mesaiUcretKatsayisi = mesaiUcretKatsayisi;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.enes.Memur{");
        sb.append("saatlikUcret=").append(saatlikUcret);
        sb.append(", maxCalismaSaati=").append(maxCalismaSaati);
        sb.append(", mesaiUcretKatsayisi=").append(mesaiUcretKatsayisi);
        sb.append('}');
        return sb.toString();
    }
}
