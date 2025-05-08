package HaratresOdev;

/**
 *
 * @author yusuf demir
 */

import java.util.*;

class Urun {
    String ad;
    double fiyat;
    int stok;
    double puan;

    Urun(String ad, double fiyat, int stok, double puan) {
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
        this.puan = puan;
    }

    @Override
    public String toString() {
        return ad + " - Fiyat: " + fiyat + ", Stok: " + stok + ", Değerlendirme: " + puan;
    }
}

class SepetUrun {
    Urun urun;
    int adet;

    SepetUrun(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }

    double getToplamFiyat(double birimFiyat) {
        return birimFiyat * adet;
    }
}

public class UrunYonetimSistemi {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Urun> urunler = new ArrayList<>();
        List<SepetUrun> sepet = new ArrayList<>();

        int urunSayisi = getIntInput("Kaç farklı ürün gireceksiniz: ", 2, Integer.MAX_VALUE);

        for (int i = 0; i < urunSayisi; i++) {
            System.out.println("\nÜrün " + (i + 1) + ":");
            String ad = getStringInput("Ürün Adı (max 20 karakter): ", 1, 20);
            double fiyat = getDoubleInput("Birim Fiyat (1 - 100): ", 1, 100);
            int stok = getIntInput("Stok Miktarı (min 1): ", 1, Integer.MAX_VALUE);
            double puan = getDoubleInput("Değerlendirme Puanı (1.0 - 5.0): ", 1.0, 5.0);
            urunler.add(new Urun(ad, fiyat, stok, puan));
        }

        System.out.print("\nÜrünleri hangi kritere göre sıralamak istersiniz? (ad/stok/puan): ");
        String kriter = scanner.nextLine().toLowerCase();
        System.out.print("Sıralama türü artan mı azalan mı olsun? (artan/azalan): ");
        String siralama = scanner.nextLine().toLowerCase();

        Comparator<Urun> comparator = switch (kriter) {
            case "ad" -> Comparator.comparing(u -> u.ad.toLowerCase());
            case "stok" -> Comparator.comparingInt(u -> u.stok);
            case "puan" -> Comparator.comparingDouble(u -> u.puan);
            default -> null;
        };

        if (comparator != null) {
            if (siralama.equals("azalan")) comparator = comparator.reversed();
            urunler.sort(comparator);
        } else {
            System.out.println("Geçersiz sıralama kriteri. Sıralama yapılmadan devam ediliyor.");
        }

        System.out.println("\nSıralanmış Ürünler:");
        urunler.forEach(System.out::println);

        while (true) {
            System.out.print("\nSepete ürün eklemek ister misiniz? (Evet/Hayır): ");
            String cevap = scanner.nextLine();
            if (!cevap.equalsIgnoreCase("Evet")) break;

            System.out.print("Eklemek istediğiniz ürünün adı: ");
            String isim = scanner.nextLine();
            Urun secilen = urunler.stream()
                    .filter(u -> u.ad.equalsIgnoreCase(isim))
                    .findFirst()
                    .orElse(null);

            if (secilen == null) {
                System.out.println("Ürün bulunamadı.");
                continue;
            }

            int adet = getIntInput("Eklemek istediğiniz adet: ", 1, secilen.stok);
            secilen.stok -= adet;

            Optional<SepetUrun> varOlan = sepet.stream()
                    .filter(s -> s.urun.ad.equalsIgnoreCase(secilen.ad))
                    .findFirst();

            if (varOlan.isPresent()) {
                varOlan.get().adet += adet;
            } else {
                sepet.add(new SepetUrun(secilen, adet));
            }

            System.out.println(secilen.ad + " sepetinize eklendi.");
        }

        System.out.println("\n🛒 Sepetiniz:");
        double toplamTutar = 0;
        for (int i = 0; i < sepet.size(); i++) {
            SepetUrun s = sepet.get(i);
            double birimFiyat = s.urun.fiyat;

            if (i < sepet.size() - 1) {
                SepetUrun sonraki = sepet.get(i + 1);
                if (birimFiyat > sonraki.urun.fiyat) {
                    birimFiyat = sonraki.urun.fiyat;
                }
            }

            double toplam = s.getToplamFiyat(birimFiyat);
            toplamTutar += toplam;
            System.out.printf("%s - Adet: %d, Toplam Fiyat: %.2f\n", s.urun.ad, s.adet, toplam);
        }

        System.out.printf("\nSepet Toplamı: %.2f TL\n", toplamTutar);
    }

    private static String getStringInput(String mesaj, int min, int max) {
        while (true) {
            System.out.print(mesaj);
            String giris = scanner.nextLine();
            if (giris.length() >= min && giris.length() <= max) return giris;
            System.out.println("Geçersiz giriş. Uzunluk: " + min + " - " + max);
        }
    }

    private static int getIntInput(String mesaj, int min, int max) {
        while (true) {
            System.out.print(mesaj);
            try {
                int sayi = Integer.parseInt(scanner.nextLine());
                if (sayi >= min && sayi <= max) return sayi;
            } catch (NumberFormatException ignored) {}
            System.out.println("Geçersiz sayı. Aralık: " + min + " - " + max);
        }
    }

    private static double getDoubleInput(String mesaj, double min, double max) {
        while (true) {
            System.out.print(mesaj);
            try {
                double sayi = Double.parseDouble(scanner.nextLine());
                if (sayi >= min && sayi <= max) return sayi;
            } catch (NumberFormatException ignored) {}
            System.out.println("Geçersiz sayı. Aralık: " + min + " - " + max);
        }
    }
}
