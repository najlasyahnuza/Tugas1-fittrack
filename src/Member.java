import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

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
    private static final DateTimeFormatter FORMAT_TANGGAL =
            DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

    private String nama = NILAI_BELUM_DIISI;
    private String noTelepon = NILAI_BELUM_DIISI;
    private String tanggalDaftar = NILAI_BELUM_DIISI;
    private String jenisPaket = PAKET_BASIC;

    /**
     * Membuat member baru dengan data lengkap. Setiap nilai diisi
     * lewat setter sehingga validasi hanya ditulis di satu tempat.
     *
     * @param nama          nama lengkap member
     * @param noTelepon     nomor telepon aktif member
     * @param tanggalDaftar tanggal pertama mendaftar, format dd-MM-yyyy
     * @param jenisPaket    jenis paket: Basic, Premium, atau VIP
     */
    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }

    /**
     * Membuat member baru tanpa menyebutkan paket. Jenis paket
     * otomatis diisi Basic.
     *
     * @param nama          nama lengkap member
     * @param noTelepon     nomor telepon aktif member
     * @param tanggalDaftar tanggal pertama mendaftar, format dd-MM-yyyy
     */
    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, PAKET_BASIC);
    }

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
     * Mengubah tanggal daftar setelah memastikan formatnya dd-MM-yyyy
     * dan tanggalnya benar-benar ada di kalender. Jika tidak valid,
     * tanggal lama dipertahankan dan alasan penolakan dicetak.
     *
     * @param tanggalDaftar tanggal daftar baru, contoh 17-08-2026
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        if (isTanggalDaftarValid(tanggalDaftar)) {
            this.tanggalDaftar = tanggalDaftar;
        } else {
            System.out.println("Tanggal \"" + tanggalDaftar + "\" ditolak: format harus "
                    + CONTOH_FORMAT_TANGGAL + " dan tanggalnya harus ada di kalender. "
                    + "Tanggal tetap: " + this.tanggalDaftar);
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

    /**
     * Mengembalikan data member dalam bentuk teks berlabel.
     *
     * @return representasi data member yang mudah dibaca
     */
    @Override
    public String toString() {
        return "Nama           : " + nama + "\n"
                + "No. Telepon    : " + noTelepon + "\n"
                + "Tanggal Daftar : " + tanggalDaftar + "\n"
                + "Jenis Paket    : " + jenisPaket;
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
        if (tanggalDaftar == null || !tanggalDaftar.matches(POLA_TANGGAL)) {
            return false;
        }
        try {
            LocalDate.parse(tanggalDaftar, FORMAT_TANGGAL);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isJenisPaketValid(String jenisPaket) {
        return PAKET_BASIC.equals(jenisPaket)
                || PAKET_PREMIUM.equals(jenisPaket)
                || PAKET_VIP.equals(jenisPaket);
    }
}