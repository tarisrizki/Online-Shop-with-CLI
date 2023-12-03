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

    //constructor
    public Transaksi(List<Barang> daftarBarang, Pembayaran metodePembayaran) {
        this.id = counter++;
        this.daftarBarang = daftarBarang;
        this.metodePembayaran = metodePembayaran;
    }

    //getter
    public int getId() {
        return id;
    }

    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public Pembayaran getMetodePembayaran() {
        return metodePembayaran;
    }
}
