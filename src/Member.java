/**
 * Merepresentasikan satu member yang terdaftar di gym FitTrack.
 * Class ini menyimpan data pribadi dan jenis paket keanggotaan member.
 */
public class Member {

    /** Nama paket keanggotaan dasar. */
    public static final String PAKET_BASIC = "Basic";

    /** Nama paket keanggotaan menengah. */
    public static final String PAKET_PREMIUM = "Premium";

    /** Nama paket keanggotaan tertinggi. */
    public static final String PAKET_VIP = "VIP";

    private static final String NILAI_BELUM_DIISI = "Belum diisi";
    private static final String AWALAN_NO_TELEPON = "0";
    private static final int PANJANG_MIN_NO_TELEPON = 10;
    private static final String POLA_HANYA_ANGKA = "\\d+";
    private static final String POLA_TANGGAL = "\\d{2}-\\d{2}-\\d{4}";
    private static final String CONTOH_FORMAT_TANGGAL = "dd-MM-yyyy";

    private String nama = NILAI_BELUM_DIISI;
    private String noTelepon = NILAI_BELUM_DIISI;
    private String tanggalDaftar = NILAI_BELUM_DIISI;
    private String jenisPaket = PAKET_BASIC;

    /**
     * Mengembalikan nama lengkap member.
     *
     * @return nama member
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengubah nama member setelah memastikan nama tidak kosong
     * dan tidak hanya berisi spasi. Jika tidak valid, nama lama
     * dipertahankan dan alasan penolakan dicetak.
     *
     * @param nama nama lengkap member yang baru
     */
    public void setNama(String nama) {
        if (isNamaValid(nama)) {
            this.nama = nama.trim();
        } else {
            System.out.println("Nama tidak boleh kosong atau hanya berisi spasi. "
                    + "Nama tetap: " + this.nama);
        }
    }

    /**
     * Mengembalikan nomor telepon member.
     *
     * @return nomor telepon member
     */
    public String getNoTelepon() {
        return noTelepon;
    }

    /**
     * Mengubah nomor telepon member setelah melalui validasi format.
     * Jika tidak valid, nomor lama dipertahankan dan alasan
     * penolakan dicetak.
     *
     * @param noTelepon nomor telepon baru, wajib diawali angka 0,
     *                  hanya berisi angka, dan minimal 10 digit
     */
    public void setNoTelepon(String noTelepon) {
        if (isNoTeleponValid(noTelepon)) {
            this.noTelepon = noTelepon;
        } else {
            System.out.println("Nomor telepon \"" + noTelepon + "\" ditolak: harus diawali angka "
                    + AWALAN_NO_TELEPON + ", hanya berisi angka, dan minimal "
                    + PANJANG_MIN_NO_TELEPON + " digit. Nomor tetap: " + this.noTelepon);
        }
    }

    /**
     * Mengembalikan tanggal member pertama kali mendaftar.
     *
     * @return tanggal daftar dalam format dd-MM-yyyy
     */
    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    /**
     * Mengubah tanggal daftar setelah memastikan formatnya konsisten
     * dengan dd-MM-yyyy. Jika tidak valid, tanggal lama dipertahankan
     * dan alasan penolakan dicetak.
     *
     * @param tanggalDaftar tanggal daftar baru, contoh 17-08-2026
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        if (isTanggalDaftarValid(tanggalDaftar)) {
            this.tanggalDaftar = tanggalDaftar;
        } else {
            System.out.println("Tanggal \"" + tanggalDaftar + "\" ditolak: format harus "
                    + CONTOH_FORMAT_TANGGAL + ". Tanggal tetap: " + this.tanggalDaftar);
        }
    }

    /**
     * Mengembalikan jenis paket keanggotaan member.
     *
     * @return jenis paket: Basic, Premium, atau VIP
     */
    public String getJenisPaket() {
        return jenisPaket;
    }

    /**
     * Mengubah jenis paket setelah memastikan nilainya salah satu
     * dari tiga paket yang tersedia. Jika tidak valid, paket lama
     * dipertahankan dan alasan penolakan dicetak.
     *
     * @param jenisPaket jenis paket baru: Basic, Premium, atau VIP
     */
    public void setJenisPaket(String jenisPaket) {
        if (isJenisPaketValid(jenisPaket)) {
            this.jenisPaket = jenisPaket;
        } else {
            System.out.println("Jenis paket \"" + jenisPaket + "\" ditolak: pilihan hanya "
                    + PAKET_BASIC + ", " + PAKET_PREMIUM + ", atau " + PAKET_VIP
                    + ". Paket tetap: " + this.jenisPaket);
        }
    }

    private boolean isNamaValid(String nama) {
        return nama != null && !nama.trim().isEmpty();
    }

    private boolean isNoTeleponValid(String noTelepon) {
        return noTelepon != null
                && noTelepon.startsWith(AWALAN_NO_TELEPON)
                && noTelepon.length() >= PANJANG_MIN_NO_TELEPON
                && noTelepon.matches(POLA_HANYA_ANGKA);
    }

    private boolean isTanggalDaftarValid(String tanggalDaftar) {
        return tanggalDaftar != null && tanggalDaftar.matches(POLA_TANGGAL);
    }

    private boolean isJenisPaketValid(String jenisPaket) {
        return PAKET_BASIC.equals(jenisPaket)
                || PAKET_PREMIUM.equals(jenisPaket)
                || PAKET_VIP.equals(jenisPaket);
    }
}