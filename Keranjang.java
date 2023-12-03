/**
 * Kelas ini merepresentasikan keranjang belanja pelanggan dengan daftar barang yang dipilih.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class Keranjang {
    private List<Barang> daftarBarang = new ArrayList<>();

    //methode manambah barang ke keranjang
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    //methode untuk membersihkan barang ke keranjang
    public void clearKeranjang() {
        daftarBarang.clear();
    }

    //getter
    public List<Barang> getListBarang() {
        return daftarBarang;
    }
}
