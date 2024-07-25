**CalorieTracker adalah aplikasi untuk menghitung angka kecukupan gizi sesuai profil pengguna serta melacak asupan kalori harian dengan memasukkan makanan yang dikonsumsi setiap harinya.**

## Nama Tim: Gen-C
### Nama Anggota:
1. H071231084 - Khalika Tsabitah Malik
2. H071231014 - Musliati
3. H071231075 - Muhammad Fauzan

## Tema yang dipilih: Food and Nutrition
## Nama pendamping: Abd. Rafiq Anwar
## Tim Juri:
1. Ufairah Bashir
2. Djulizah Bonita

## Latar Belakang dan Tujuan
Pola makan yang tidak seimbang telah memicu peningkatan masalah kesehatan seperti obesitas dan kekurangan gizi di masyarakat. Banyak orang tidak menyadari nutrisi yang terkandung dalam makanan yang mereka konsumsi. Hal ini membuat mereka sulit untuk mengelola asupan gizi dengan baik. Kurangnya informasi dan kesadaran tentang nutrisi menjadi salah satu faktor utama yang menyebabkan masalah ini. Untuk mengatasi permasalahan ini, CalorieTracker dirancang untuk membantu individu menghitung kecukupan gizi harian mereka berdasarkan usia, jenis kelamin, berat dan tinggi badan, serta tingkat aktivitas yang mereka lakukan. Proyek ini juga memungkinkan pengguna untuk melacak asupan kalori dengan memasukkan makanan yang mereka konsumsi, sehingga mereka dapat melihat riwayat asupan kalori sebelumnya dan mengelola pola makan mereka dengan lebih efektif dan sehat.

## Fitur Aplikasi
- **Sign Up:** Pengguna baru dapat membuat akun dengan memasukkan informasi dasar seperti username dan kata sandi.
- **Sign In:** Pengguna dapat masuk ke akun mereka dengan menggunakan username dan kata sandi yang telah didaftarkan.
- **Profil Pengguna:** Pengguna dapat membuat profil dengan memasukkan informasi seperti nama, usia, jenis kelamin, berat badan, tinggi badan, dan tingkat aktivitas fisik.
- **Kalkulator Kalori Harian:** Menghitung kebutuhan kalori harian berdasarkan profil pengguna untuk membantu mereka memahami jumlah kalori yang harus dikonsumsi setiap hari.
- **Reset Profil:** Pengguna dapat mengatur ulang profil yang telah dimasukkan. Kalori harian juga akan dihitung ulang berdasarkan profil terbaru.
- **Database Makanan:** Menyediakan database yang luas tentang makanan beserta informasi nutrisinya, termasuk kalori, protein, lemak, dan karbohidrat.
- **Pencatatan Makanan Harian:** Memungkinkan pengguna untuk mencatat makanan yang mereka konsumsi setiap hari. Pengguna dapat mencari makanan dalam database yang tersedia.
- **Pelacakan Nutrisi:** Melacak asupan nutrisi harian pengguna dan membandingkannya dengan kebutuhan gizi harian mereka. Fitur ini membantu pengguna memastikan bahwa mereka mendapatkan nutrisi yang cukup dan seimbang.
- **Menghapus Riwayat Makanan:** Pengguna dapat menghapus riwayat makanan yang telah dicatat sebelumnya. Fitur ini memungkinkan pengguna untuk mengelola dan memperbarui data asupan kalori dan nutrisi mereka dengan lebih akurat.
- **Peringatan:** Memberikan peringatan jika pengguna melebihi batas kalori atau nutrisi yang disarankan.

## Tampilan Aplikasi
### Splash Screen
![Screenshot (223)](https://github.com/user-attachments/assets/a852ac4a-c449-4795-a74d-b6f6c947737f)
### Halaman Sign In
![Screenshot (224)](https://github.com/user-attachments/assets/9fce5ff3-de41-421f-a85d-f06267ca5fc7)
### Halaman Sign Up
![Screenshot (225)](https://github.com/user-attachments/assets/20beff6a-2f96-4999-91a0-0aa331a73520)
### Halaman Hitung AKG (sebelum dan sesudah diisi)
![Screenshot (226)](https://github.com/user-attachments/assets/8f699a58-58fc-4780-9164-044959a51f34)
![Screenshot (227)](https://github.com/user-attachments/assets/a6c8f9db-a4f8-4226-83fc-d26aecc28c81)
### Halaman Profil
![Screenshot (228)](https://github.com/user-attachments/assets/52f70c2a-36c9-4ba2-8143-5b411a9a9fc8)
### Halaman Laporan Harian (sebelum dan sesudah diisi)
![Screenshot (229)](https://github.com/user-attachments/assets/4f54ab4b-a971-48a2-aacd-771ef49d8c6b)
![Screenshot (232)](https://github.com/user-attachments/assets/03fc968f-765d-4424-9f73-44692e4814fd)
### Halaman Tambah Makanan (sebelum dan sesudah memilih makanan)
![Screenshot (230)](https://github.com/user-attachments/assets/92d20088-0a65-4fa0-9615-32f81ef83303)
![Screenshot (231)](https://github.com/user-attachments/assets/8d31fdf7-bd15-47f4-91d5-e18bb9f4622a)

## Pengujian Aplikasi
| No | Deskripsi Pengujian | Hasil yang Diharapkan | Hasil |
|----|----------------------|-----------------------|-------|
| 1  | Pencobaan login dengan username atau password yang salah | Sistem dapat menampilkan pesan kesalahan yang sesuai jika username atau password yang dimasukkan salah | Berhasil |
| 2  | Pencobaan login tanpa mengisi username atau password | Aplikasi dapat menampilkan pesan kesalahan yang sesuai jika username atau password tidak diisi | Berhasil |
| 3  | Pencobaan mendaftar dan login dengan data yang valid | Pengguna dapat mendaftar dan login dengan sukses | Berhasil |
| 4  | Pencobaan menghitung AKG berdasarkan data pengguna seperti usia, berat, tinggi, jenis kelamin, dan tingkat aktivitas | Sistem menghitung dan menampilkan kebutuhan AKG harian yang sesuai dengan data yang dimasukkan pengguna | Berhasil |
| 5  | Pencobaan menghitung AKG saat pengguna memasukkan inputan usia/berat badan/tinggi badan yang berupa huruf atau angka negatif | Aplikasi dapat menampilkan pesan kesalahan yang sesuai jika inputan tidak valid | Berhasil |
| 6  | Menyambungkan database daftar makanan dengan aplikasi | Aplikasi menampilkan daftar makanan beserta rincian kalori, karbohidrat, protein, dan lemak | Berhasil |
| 7  | Mencari makanan sesuai dengan yang diinginkan | Aplikasi dapat menampilkan makanan yang dicari pada daftar teratas | Berhasil |
| 8  | Menghitung total kalori, protein, lemak, dan karbohidrat berdasarkan makanan yang dipilih | Aplikasi dapat menghitung total kalori, protein, lemak, dan karbohidrat berdasarkan makanan yang dipilih | Berhasil |
| 9  | Menyimpan riwayat makanan | Aplikasi menyimpan data makanan yang dikonsumsi pengguna ke dalam riwayat makanan | Berhasil |
| 10 | Mengatur ulang riwayat makanan | Aplikasi dapat mengatur ulang (menghapus) semua data riwayat makanan yang disimpan | Berhasil |
| 11 | Menghitung ulang kebutuhan AKG | Aplikasi dapat menghitung ulang AKG harian sesuai dengan data terbaru yang dimasukkan pengguna | Berhasil |
| 12 | Menyesuaikan laporan harian berdasarkan AKG terbaru | Aplikasi menyesuaikan dan menampilkan laporan harian berdasarkan kebutuhan AKG terbaru pengguna | Berhasil |
| 13 | Pencobaan sign out pengguna | Aplikasi berhasil melakukan sign out pengguna dan mengarahkan pengguna kembali ke halaman login | Berhasil |
