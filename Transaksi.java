/**
 * Kelas ini merepresentasikan transaksi yang terjadi setelah proses checkout. Setiap transaksi memiliki ID unik.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.List;

class Transaksi {
    private static int counter = 1;
    private int id;
    private List<Barang> daftarBarang;
    private Pembayaran metodePembayaran;

    /**
     * Konstruktor untuk membuat objek Transaksi dengan daftar barang dan metode pembayaran tertentu.
     * 
     * @param daftarBarang     List<Barang> Daftar barang yang dibeli dalam transaksi.
     * @param metodePembayaran Pembayaran Metode pembayaran yang digunakan dalam transaksi.
     */
    public Transaksi(List<Barang> daftarBarang, Pembayaran metodePembayaran) {
        this.id = counter++;
        this.daftarBarang = daftarBarang;
        this.metodePembayaran = metodePembayaran;
    }

    /**
     * Getter untuk mendapatkan ID transaksi.
     * 
     * @return int ID transaksi.
     */
    public int getId() {
        return id;
    }
    /**
     * Getter untuk mendapatkan daftar barang dalam transaksi.
     * 
     * @return List<Barang> Daftar barang dalam transaksi.
     */
    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }
    /**
     * Getter untuk mendapatkan metode pembayaran dalam transaksi.
     * 
     * @return Pembayaran Metode pembayaran dalam transaksi.
     */
    public Pembayaran getMetodePembayaran() {
        return metodePembayaran;
    }
}
