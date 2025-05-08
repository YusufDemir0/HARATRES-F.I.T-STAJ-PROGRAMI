# 📘 Haratres Teknoloji FIT Staj Programı – Java Uygulama Projesi

Bu proje, Haratres Teknoloji 2024 FIT Staj Programı değerlendirme ödevi kapsamında hazırlanmıştır. Proje iki ana Java uygulamasından oluşmaktadır:

1. **Harf Sayacı (Character Counter)**
2. **Dinamik Ürün Yönetim ve Sepet Sistemi (E-Ticaret Simülasyonu)**

---

## 🧩 Proje İçeriği

### 1️⃣ Harf Sayacı (`HarfSayaci.java`)

Bu program, kullanıcıdan alınan bir cümlede belirli bir karakterin kaç kez geçtiğini hesaplar.

#### Özellikler:
- Maksimum karakter sınırı belirleme
- Cümle girişi ve sınır aşımı kontrolü
- Büyük/küçük harf duyarlılığı tercihi (case sensitivity)
- Harf girişi kontrolü (sadece tek karakter izinli)
- Geçerli olmayan girişlerde kullanıcıyı uyarma
- Elde edilen karakter tekrar sayısını kullanıcıya gösterme

---

### 2️⃣ Dinamik Ürün Yönetim Sistemi (`UrunYonetimSistemi.java`)

Bu program bir e-ticaret platformunun temel işlevlerini simüle eder: ürün girişi, sıralama, sepete ekleme ve indirimli toplam hesaplama.

#### Özellikler:
- Birden fazla ürün tanımlama (isim, fiyat, stok, değerlendirme puanı)
- Giriş doğrulama: isim uzunluğu, fiyat ve stok sınırları
- Ürünleri ad, stok ya da puana göre sıralama (artan/azalan)
- Sepete ürün ekleme ve stok kontrolü
- Aynı ürünü tekrar eklerseniz miktar artırılır
- Sepet için özel indirim algoritması:
  - Eğer bir ürün bir sonrakinden daha pahalıysa, daha düşük fiyat uygulanarak indirim yapılır

---

## 🔧 Gereksinimler

- Java JDK 11 veya üzeri
- Komut satırı (Terminal / CMD) veya herhangi bir Java IDE (Örn: IntelliJ IDEA, Eclipse, NetBeans)

---

## ▶️ Çalıştırma

```bash
# Harf Sayacı
javac HarfSayaci.java
java HarfSayaci

# Ürün Yönetim Sistemi
javac UrunYonetimSistemi.java
java UrunYonetimSistemi
```

---

## 📂 Proje Yapısı

```
HaratresOdev/
│
├── HarfSayaci.java              // Karakter analiz uygulaması
├── UrunYonetimSistemi.java      // E-ticaret simülasyonu
└── README.md                    // Proje açıklamaları
```

---

## 👤 Geliştirici

**Yusuf Demir**  
Bilgisayar Mühendisliği 4. Sınıf  
Kocaeli Üniversitesi  
[GitHub: YusufDemir0](https://github.com/YusufDemir0)
