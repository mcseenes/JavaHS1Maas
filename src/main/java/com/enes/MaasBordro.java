package com.enes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import static com.enes.utility.PersonelDB.personelList;

public class MaasBordro {
//    DecimalFormat df = new DecimalFormat("#,##0.00");

    public void wageReport() {
        saatKontrol();

        double mesai = 0;
        double yoneticiBonusu = 0;

        for (Personel personel : personelList) {
            File path = new File("C:\\Users\\ESMANUR" +
                    "\\eclipse-workspace\\src\\main\\resources\\YoneticiVeMemurListesi.json"
                    + personel.getAd() + personel.getPozisyon());
            path.mkdirs();
            String personelNameJson = path + "/" + personel.getAd() + personel.getPozisyon() + ".json";

            try {
                FileWriter writer = new FileWriter(personelNameJson);
                writer.write("Maas Bordro, " + "SUBAT" + " " + " 2020" + "\n====================\n");
                writer.write("Personel Ismi: " + personel.getAd() + "\n");
                writer.write("Calisma Saati: " + personel.getCalismaSaati() + "\n");


                if (personel instanceof Memur) {
                    writer.write("Ana Odeme: ₺" + ((Memur)personel).maasHesapla(150) + "\n");
                    yoneticiBonusu = 0d;
                    mesai = ((Memur) personel).maasHesapla(100);
                    writer.write("Mesai: ₺" + (mesai) + "\n");
                }

                if (personel instanceof Yonetici) {
                    writer.write("Ana Odeme: ₺" + ((Yonetici)personel).maasHesapla(150) + "\n");
                    yoneticiBonusu = (((Yonetici) personel).getBonus());
                    mesai = 0d;
                    writer.write("Yonetici Bonusu: ₺" + (yoneticiBonusu) + "\n");
                }
                writer.write("====================\n");
                mesai = ((Yonetici) personel).maasHesapla(100);
                writer.write("Toplam Odeme: ₺" + (mesai + yoneticiBonusu +
                        ((Yonetici) personel).maasHesapla(100)) + "\n");
                writer.write("====================\n");
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saatKontrol() {
        boolean saat150 = false;
        boolean saat10 = false;

        for (Personel personel : personelList) {
            if (personel.getCalismaSaati() < 150) {
                System.out.println(personel.getAd() + " " + personel.getAd() + " 150 saatten az çalışmıştır.");
                saat150 = true;
            }
            if (personel.getCalismaSaati() < 10) {
                System.out.println(personel.getAd() + " " + personel.getAd() + " 10 saatten az çalışmıştır.");
                saat10 = true;
            }
        }

        if (!saat150) {
            System.out.println("Hiçbir personel 150 saatten az çalışmamıştır.");
        }
        if (!saat10) {
            System.out.println("Hiçbir personel 10 saatten az çalışmamıştır.");
        }
    }
}