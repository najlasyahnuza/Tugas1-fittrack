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
     * Mengubah nama member.
     *
     * @param nama nama lengkap member yang baru
     */
    public void setNama(String nama) {
        this.nama = nama;
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
     * Mengubah nomor telepon member.
     *
     * @param noTelepon nomor telepon aktif member yang baru
     */
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
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
     * Mengubah tanggal daftar member.
     *
     * @param tanggalDaftar tanggal daftar baru dalam format dd-MM-yyyy
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
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
     * Mengubah jenis paket keanggotaan member.
     *
     * @param jenisPaket jenis paket baru: Basic, Premium, atau VIP
     */
    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }
}