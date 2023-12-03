public class Invoice {
    private static int counter = 1; // Untuk meng-generate ID invoice secara otomatis
    private int id;
    private Transaksi transaksi;
    private Pembayaran pembayaran;

    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.id = counter++;
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    // Getter sesuai kebutuhan
    public int getId() {
        return id;
    }
}