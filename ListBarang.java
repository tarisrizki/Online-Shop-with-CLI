/**
 * Kelas ini merepresentasikan daftar barang yang tersedia di toko online.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class ListBarang {
    private List<Barang> listBarang = new ArrayList<>();

    //constructor
    public void addBarang(Barang barang) {
        listBarang.add(barang);
    }

    //methode untuk hapus barang
    public void hapusBarang(String id) {
        Barang barang = cariBarang(id);
        if (barang != null) {
            listBarang.remove(barang);
        }
    }

    //methode untuk menampilkan barang yang tersedia
    public void displayBarang() {
        System.out.println("Daftar Barang yang Tersedia:");
        for (Barang barang : listBarang) {
            System.out.println(barang);
        }
    }

    //methode untuk cari barang
    public Barang cariBarang(String kode) {
        for (Barang barang : listBarang) {
            if (barang.getId().equals(kode)) {
                return barang;
            }
        }
        return null;
    }
}
