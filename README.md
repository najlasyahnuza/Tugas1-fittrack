# Tugas 1 FitTrack

Nama: Najla Putri Syahnuza
NPM: 250810701100115
Kelas: A

## Deskripsi
Program ini untuk mencatat data member gym FitTrack. Setiap data yang dimasukkan dicek dulu, jadi kalau ada data yang salah (misalnya nomor telepon ada hurufnya atau paket yang tidak tersedia), data itu ditolak tanpa membuat program berhenti.

## Fitur
- Menambah member dengan nama, no telepon, tanggal daftar, dan jenis paket
- Menambah member tanpa pilih paket, otomatis jadi Basic
- Menolak nama kosong, no telepon yang salah format, tanggal yang bukan dd-MM-yyyy, dan paket selain Basic/Premium/VIP
- Menampilkan alasan kalau data ditolak
- Menampilkan semua data member

## Konsep OOP
| Konsep | Dipakai di | Alasan |
|---|---|---|
| Enkapsulasi | atribut private, getter dan setter | supaya data cuma bisa diubah lewat setter yang ada validasinya |
| Overloading | 2 constructor Member | biar bisa buat member dengan atau tanpa paket, yang 3 parameter manggil yang 4 parameter jadi tidak ada kode dobel |
| Override | toString() | supaya yang dicetak data member, bukan Member@xxxx |
| Array + for | TesFitTrack | untuk menyimpan banyak member dan mencetaknya satu per satu |

## Struktur
```
src/
  Member.java
  TesFitTrack.java
screenshot/output.png
.gitignore
README.md
```

## Prasyarat
JDK , IntelliJ IDEA

## Cara Menjalankan
IntelliJ: buka folder project, buka `src/TesFitTrack.java`, lalu klik Run di method main.

Command line (dari folder project):
```
javac -d out src/Member.java src/TesFitTrack.java
java -cp out TesFitTrack
```

## Output
Member 1-3 data normal, member 4-5 dan uji setter nomor telepon menunjukkan data yang ditolak.


## Nilai Default
- nama, noTelepon, tanggalDaftar: "Belum diisi", supaya kelihatan datanya belum lengkap dan tidak muncul null waktu dicetak
- jenisPaket: Basic, karena itu paket paling dasar jadi member tidak dapat fasilitas yang belum dibayar

Nilai default ditulis langsung di atribut, jadi kalau setter menolak data di constructor, atributnya tetap berisi nilai ini.

## Batasan
- Tanggal cuma dicek formatnya, jadi tanggal seperti 31-02-2026 masih diterima
- Data member belum disimpan ke file, hilang setelah program selesai
- Data masih ditulis di kode, belum ada input dari pengguna