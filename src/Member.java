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
}