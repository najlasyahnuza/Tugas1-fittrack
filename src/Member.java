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

    private boolean isNamaValid(String nama) {
        return nama != null && !nama.trim().isEmpty();
    }

    private boolean isNoTeleponValid(String noTelepon) {
        return noTelepon != null
                && noTelepon.startsWith(AWALAN_NO_TELEPON)
                && noTelepon.length() >= PANJANG_MIN_NO_TELEPON
                && noTelepon.matches(POLA_HANYA_ANGKA);
    }
}