import java.util.ArrayList;
import java.util.List;

class Keranjang {
    private List<Barang> daftarBarang = new ArrayList<>();

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void clearKeranjang() {
        daftarBarang.clear();
    }

    public List<Barang> getListBarang() {
        return daftarBarang;
    }
}
