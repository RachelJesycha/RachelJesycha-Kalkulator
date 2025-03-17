# 📱 Kalkulator Android  
Aplikasi Kalkulator sederhana berbasis Android yang dibuat menggunakan **Jetpack Compose**. Aplikasi ini mendukung operasi matematika dasar dan memiliki tampilan modern menggunakan Material3.  

## ✨ Fitur  
✅ Operasi dasar: penjumlahan (+), pengurangan (-), perkalian (×), pembagian (÷)  
✅ Dukungan bilangan desimal  
✅ Tampilan responsif dengan Material Design 3  
✅ Dukungan mode gelap  

## 🛠️ Teknologi yang Digunakan  
- **Struktur:** MVVM
- **Bahasa:** Kotlin [Jetpack Compose]
- **Framework UI:** XML/Jetpack Compose  
- **Material Design 3** untuk tampilan modern  
- **ViewModel & LiveData** untuk manajemen data (jika diperlukan)  

## 📁 Struktur Folder
```
RachelJesychaKalkulator/
│── .gradle/
│── .idea/
│── app/
│   ├── build/
│   ├── src/
│   │   ├── androidTest/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com/example/racheljesycha/
│   │   │   │   │   ├── data/
│   │   │   │   │   ├── di/
│   │   │   │   │   ├── domain/
│   │   │   │   │   ├── ui/
|   │   │   │   │   │   ├── components/
|   │   │   │   │   │   ├── navigation/
|   │   │   │   │   │   ├── screen/
|   |   │   │   │   │   │   ├── 📝 CalculatorScreen.kt
|   │   │   │   │   │   ├── theme/
|   |   │   │   │   │   │   ├── Color.kt
|   |   │   │   │   │   │   ├── Theme.kt
|   |   │   │   │   │   │   ├── Type.kt
│   │   │   │   │   ├── utils/
│   │   │   │   │   ├── viewmodel/
|   │   │   │   │   │   ├── 📝 CalculatorViewModel.kt
│   │   │   │   │   ├── 📝 MainActivity.java
│   │   │   ├── res/
│   │   │   ├── AndroidManifest.xml
│   │   ├── test/ [unitTest]
│── .gitignore
│── build.gradle.kts
│── proguard-rules.pro
```
## ✍️ Notes
1. CalculatorScreen.kt: Berisi desain UI kalkulator dengan menggunakan Material3
2. CalculatorViewModel.kt: Berisi function perkalian, pengurangan, penambahan, pembagian dan persen
3. MainActivity.kt: Berisi view untuk menampilkan UI pada ```calculatorScreen.kt```.
   
## 🚀 Instalasi  
1. **Clone repositori** ini ke komputer Anda:  
   ```bash
   git clone https://github.com/RachelJesycha/RachelJesycha-Kalkulator.git

## 📌 Author
- 👤 **Nama:** Rachel Jesycha
- 🪪 **NIM:**  225150407111009

