import java.util.ArrayList;

public class ListBarang {
    public ArrayList<Barang> listBarang = new ArrayList<>();

    public void addBarang(Barang barang) {
        listBarang.add(barang);
    }

    public void hapusBarang(String id) {
        // Hapus barang dengan ID yang sesuai
        Barang barang = cariBarang(id);
        if (barang != null) {
            listBarang.remove(barang);
        }
    }

    public Barang cariBarang(String id) {
        // Cari barang dengan ID yang sesuai
        for (Barang barang : listBarang) {
            if (barang.getId().equals(id)) {
                return barang;
            }
        }
        return null; // Return null jika barang tidak ditemukan
    }
}