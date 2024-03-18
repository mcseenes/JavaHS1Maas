package com.enes;
import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static com.enes.utility.PersonelDB.personelList;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        DosyaOku dosyaOku=new DosyaOku();
        dosyaOku.okuma();
    }
}
