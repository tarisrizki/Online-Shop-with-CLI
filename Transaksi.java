import java.util.ArrayList;

public class Transaksi {
    private static int counter = 1; // Untuk meng-generate ID transaksi secara otomatis
    private int id;
    private List<Barang> daftarBarang;
    private Pembayaran metodePembayaran;

    public Transaksi(List<Barang> daftarBarang, Pembayaran metodePembayaran) {
        this.id = counter++;
        this.daftarBarang = daftarBarang;
        this.metodePembayaran = metodePembayaran;
    }

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
