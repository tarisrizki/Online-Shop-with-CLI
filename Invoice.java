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

    /**
     * Konstruktor untuk membuat objek Invoice dengan transaksi dan metode pembayaran.
     * 
     * @param transaksi   Objek Transaksi yang berisi detail pembelian.
     * @param pembayaran  Objek Pembayaran yang digunakan untuk transaksi.
     */
    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.id = counter++;
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    /**
     * Mendapatkan ID unik dari invoice.
     * 
     * @return int ID unik dari invoice.
     */
    public int getId() {
        return id;
    }
}
