# Tugas 1: Sistem Keanggotaan Gym FitTrack (Remedial UTS Praktikum PBO)

Nama: Najla Putri Syahnuza
NPM: 250810701100115
Mata Kuliah: Praktikum Pemrograman Berorientasi Objek

## Deskripsi
Program ini untuk mencatat data member gym FitTrack. Setiap data yang dimasukkan dicek dulu, jadi kalau ada data yang salah (misalnya nomor telepon ada hurufnya atau paket yang tidak tersedia), data itu ditolak tanpa membuat program berhenti.

## Fitur
- Menambah member dengan nama, no telepon, tanggal daftar, dan jenis paket
- Menambah member tanpa pilih paket, otomatis jadi Basic
- Menolak nama kosong, no telepon yang salah format, tanggal yang bukan dd-MM-yyyy atau tidak ada di kalender (misalnya 31-02-2026), dan paket selain Basic/Premium/VIP
- Menampilkan alasan kalau data ditolak
- Menampilkan semua data member

## Konsep OOP
| Konsep | Dipakai di | Alasan |
|---|---|---|
| Enkapsulasi | atribut private, getter dan setter | supaya data cuma bisa diubah lewat setter yang ada validasinya |
| Overloading | 2