import java.util.ArrayList;

public class Keranjang {
    public ArrayList<Barang> barang = new ArrayList<>();

    public void tambahBarang(Barang barang) {
        this.barang.add(barang);
    }

    public void clearKeranjang() {
        daftarBarang.clear();
    }

    public List<Barang> getListBarang() {
        return daftarBarang;
    }
}
