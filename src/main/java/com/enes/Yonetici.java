package com.enes;

public class Yonetici extends Personel{
    private double saatlikUcret;
    private double bonus;

    public Yonetici(String ad, String pozisyon, int calismaSaati) {
        super(ad, pozisyon, calismaSaati);
    }


    // Yönetici için maaş hesaplama
    @Override
    public double maasHesapla(int calismaSaati) {
        double maas;
        maas=saatlikUcret * calismaSaati + bonus;
        System.out.println("MAASINIZ:"+maas);
        return maas;
    }
    public double getSaatlikUcret() {
        return saatlikUcret;
    }

    public void setSaatlikUcret(double saatlikUcret) {
        this.saatlikUcret = saatlikUcret;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.enes.Yonetici{");
        sb.append("saatlikUcret=").append(saatlikUcret);
        sb.append(", bonus=").append(bonus);
        sb.append('}');
        return sb.toString();
    }
}
