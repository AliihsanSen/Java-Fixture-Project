package Fikstur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fikstur {

    static Scanner scan = new Scanner(System.in);
    static int takimSayisi;

    public static void main(String[] args) {

        System.out.print("Liginiz kaç takımlı olsun ? ==> ");
        takimSayisi = scan.nextInt();
        List<String> takimlar = new ArrayList<>();

        while (takimlar.size() != takimSayisi) {
            System.out.print("Takimlari giriniz : ");
            takimlar.add(scan.next());
        }

        if (takimSayisi % 2 != 0) {
            takimlar.add("BAY");
            takimSayisi++;
        }

        List<String> karilmisTakimlar = new ArrayList<>();

        for (int i = 0; i < takimSayisi; i++) {
            int rnd = new Random().nextInt(takimlar.size());
            karilmisTakimlar.add(takimlar.get(rnd));
            takimlar.remove(takimlar.get(rnd));
        }

        haftalikMaclar(karilmisTakimlar);
    }

    public static void haftalikMaclar(List<String> karilmisTakimlar) {

        int hafta = 1;

        while (hafta <= 2 * takimSayisi - 2) {
            System.out.println(); // ==> Hafta sıralamalarında boşluk olabilmesi için atılmıştır.
            System.out.println("hafta = " + hafta);
            String takimX = "";
            String takimY = "";

            for (int i = 0; i < takimSayisi / 2; i++) {

                if (i == 0 && hafta % 2 != 0) {
                    takimY = karilmisTakimlar.get(i);
                    takimX = karilmisTakimlar.get(takimSayisi - i - 1);
                } else if (hafta % 2 == 0) {
                    takimX = karilmisTakimlar.get(i);
                    takimY = karilmisTakimlar.get(takimSayisi - i - 1);
                } else {
                    takimX = karilmisTakimlar.get(i);
                    takimY = karilmisTakimlar.get(takimSayisi - i - 1);
                }

                if (hafta < takimSayisi) {
                    System.out.println(takimX + " vs " + takimY);
                } else {
                    System.out.println(takimY + " vs " + takimX);
                }

            }

            String cikarilanTakim = karilmisTakimlar.get(1);
            karilmisTakimlar.remove(cikarilanTakim);
            karilmisTakimlar.add(cikarilanTakim);
            hafta++;

        }
    }
}
