import java.util.ArrayList;

public class Transaksi {
    private static int counter = 1; // Untuk meng-generate ID transaksi secara otomatis
    private int id;
    private Customer customer;
    private ArrayList<Barang> barang;

    public Transaksi(Customer customer, ArrayList<Barang> barang) {
        this.id = counter++;
        this.customer = customer;
        this.barang = barang;
    }

    // Getter sesuai kebutuhan
    public int getId() {
        return id;
    }
}