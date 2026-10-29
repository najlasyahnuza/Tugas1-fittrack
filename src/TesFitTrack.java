/**
 * Menjalankan skenario uji sistem keanggotaan FitTrack: membuat
 * beberapa member, menguji validasi, dan mencetak seluruh data member.
 */
public class TesFitTrack {

    /**
     * Titik masuk program yang menjalankan seluruh skenario uji.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        System.out.println("=== Membuat data member ===");
        Member[] daftarMember = buatDaftarMember();

        System.out.println();
        System.out.println("=== Uji setter dengan nilai tidak valid ===");
        ujiSetterTidakValid(daftarMember[0]);

        System.out.println();
        System.out.println("=== Daftar seluruh member ===");
        cetakSemuaMember(daftarMember);
    }

    /**
     * Membuat array member berisi data normal dan data yang sengaja
     * melanggar validasi.
     *
     * @return array berisi seluruh member yang dibuat
     */
    private static Member[] buatDaftarMember() {
        return new Member[] {
                new Member("Andi Pratama", "081234567890", "17-08-2026", Member.PAKET_BASIC),
                new Member("Siti Rahmawati", "085211223344", "20-08-2026", Member.PAKET_PREMIUM),
                new Member("Budi Santoso", "081398765432", "01-09-2026", Member.PAKET_VIP),
                new Member("Dewi Lestari", "081200001111", "05-09-2026"),
                new Member("   ", "0812345678", "2026/09/10", "Gold"),
                new Member("Rina Marlina", "6281234", "31-02-2026", Member.PAKET_PREMIUM)
        };
    }

    /**
     * Memanggil setter dengan nilai tidak valid pada member yang sudah
     * terbentuk, lalu menampilkan bahwa nilai lamanya tetap bertahan.
     *
     * @param member member yang akan diuji
     */
    private static void ujiSetterTidakValid(Member member) {
        System.out.println("Nomor sebelum diubah : " + member.getNoTelepon());
        member.setNoTelepon("12345");
        System.out.println("Nomor setelah diubah : " + member.getNoTelepon());
    }

    /**
     * Mencetak seluruh member di dalam array memakai perulangan for.
     *
     * @param daftarMember array member yang akan dicetak
     */
    private static void cetakSemuaMember(Member[] daftarMember) {
        for (int i = 0; i < daftarMember.length; i++) {
            System.out.println("Member ke-" + (i + 1));
            System.out.println(daftarMember[i]);
            System.out.println();
        }
    }
}