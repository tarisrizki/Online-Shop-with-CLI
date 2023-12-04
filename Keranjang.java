/**
 * Kelas ini merepresentasikan keranjang belanja pelanggan dengan daftar barang yang dipilih.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class Keranjang {
    private List<Barang> daftarBarang = new ArrayList<>();

    /**
     * Menambahkan barang ke dalam keranjang.
     * 
     * @param barang Objek Barang yang akan ditambahkan ke keranjang.
     */
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    /**
     * Membersihkan semua barang dalam keranjang.
     */
    public void clearKeranjang() {
        daftarBarang.clear();
    }

    /**
     * Mendapatkan daftar barang dalam keranjang.
     * 
     * @return List<Barang> Daftar barang dalam keranjang.
     */
    public List<Barang> getListBarang() {
        return daftarBarang;
    }
}
