package HaratresOdev;

/**
 *
 * @author yusuf demir 
 */
import java.util.Scanner;

public class HarfSayaci {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Maksimum karakter sayısı belirleyin: ");
            int maxChar = scanner.nextInt();
            scanner.nextLine(); 
            
            String cumle = "";
            while (true) {
                System.out.print("Lütfen bir cümle girin: ");
                cumle = scanner.nextLine();
                
                if (cumle.length() <= maxChar) break;
                System.out.println("Cümle karakter sınırını aştı. Lütfen tekrar girin.");
            }
            
            
            boolean caseSensitive = false;
            while (true) {
                System.out.print("Büyük/küçük harf duyarlılığı aktif olsun mu? (Evet/Hayır): ");
                String secim = scanner.nextLine().trim();
                
                if (secim.equalsIgnoreCase("Evet")) {
                    caseSensitive = true;
                    break;
                } else if (secim.equalsIgnoreCase("Hayır")) {
                    caseSensitive = false;
                    break;
                } else {
                    System.out.println("Lütfen geçerli bir cevap giriniz.");
                }
            }
            
            
            char hedefKarakter;
            while (true) {
                System.out.print("Analiz etmek için bir harf girin: ");
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    hedefKarakter = input.charAt(0);
                    break;
                } else {
                    System.out.println("Geçerli bir karakter giriniz.");
                }
            }
            
            int sayac = 0;
            for (char ch : cumle.toCharArray()) {
                if (caseSensitive) {
                    if (ch == hedefKarakter) sayac++;
                } else {
                    if (Character.toLowerCase(ch) == Character.toLowerCase(hedefKarakter)) sayac++;
                }
            }
            
            System.out.println("Girilen cümlede '" + hedefKarakter + "' harfi toplamda " + sayac + " defa geçmektedir.");
        }
    }
}
