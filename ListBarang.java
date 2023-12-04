/**
 * Kelas ini merepresentasikan daftar barang yang tersedia di toko online.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class ListBarang {
    private List<Barang> listBarang = new ArrayList<>();

    /**
     * Menambahkan barang ke dalam daftar barang.
     * 
     * @param barang Objek Barang yang akan ditambahkan ke daftar barang.
     */
    public void addBarang(Barang barang) {
        listBarang.add(barang);
    }

     /**
     * Menghapus barang dari daftar barang berdasarkan ID.
     * 
     * @param id String ID barang yang akan dihapus.
     */
    public void hapusBarang(String id) {
        Barang barang = cariBarang(id);
        if (barang != null) {
            listBarang.remove(barang);
        }
    }

     /**
     * Menampilkan daftar barang yang tersedia.
     */
    public void displayBarang() {
        System.out.println("Daftar Barang yang Tersedia:");
        for (Barang barang : listBarang) {
            System.out.println(barang);
        }
    }

    /**
     * Mencari barang berdasarkan ID.
     * 
     * @param kode String ID barang yang akan dicari.
     * @return Barang Objek Barang jika ditemukan, atau null jika tidak ditemukan.
     */
    public Barang cariBarang(String kode) {
        for (Barang barang : listBarang) {
            if (barang.getId().equals(kode)) {
                return barang;
            }
        }
        return null;
    }
}
