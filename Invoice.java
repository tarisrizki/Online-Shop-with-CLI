/**
 * Kelas ini merepresentasikan invoice yang dibuat setelah proses checkout. Setiap invoice memiliki ID unik.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
public class Invoice {
    private static int counter = 1; // Untuk meng-generate ID invoice secara otomatis
    private int id;
    public Transaksi transaksi;
    public Pembayaran pembayaran;

    //constructor
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
