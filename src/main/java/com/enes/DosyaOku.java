package com.enes;
import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static com.enes.utility.PersonelDB.personelList;

public class DosyaOku {
    public void okuma() throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\ESMANUR\\eclipse-workspace\\JavaHS1Maas\\src\\main\\resources\\Personel.json"));
            JsonArray array = (JsonArray) obj;
            for (Object o : array) {
                JsonObject person = (JsonObject) o;
                String ad = person.get("ad").getAsString();
                System.out.println(ad);
                String pozisyon = person.get("pozisyon").getAsString().toUpperCase();
                System.out.println(pozisyon);
                int calismaSaati = person.get("saat").getAsInt();
                System.out.println(pozisyon);
                if (pozisyon.equalsIgnoreCase("yonetici")) {
                    personelList.add(new Yonetici(ad,pozisyon,calismaSaati));
                } else if (pozisyon.equalsIgnoreCase("memur")) {
                    personelList.add(new Memur(ad,pozisyon,calismaSaati));
                }
            }
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
