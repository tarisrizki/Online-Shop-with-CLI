import java.util.ArrayList;
import java.util.List;

class ListBarang {
    private List<Barang> listBarang = new ArrayList<>();

    public void addBarang(Barang barang) {
        listBarang.add(barang);
    }

    public void hapusBarang(String id) {
        Barang barang = cariBarang(id);
        if (barang != null) {
            listBarang.remove(barang);
        }
    }

    public void displayBarang() {
        System.out.println("Daftar Barang yang Tersedia:");
        for (Barang barang : listBarang) {
            System.out.println(barang);
        }
    }

    public Barang cariBarang(String kode) {
        for (Barang barang : listBarang) {
            if (barang.getId().equals(kode)) {
                return barang;
            }
        }
        return null;
    }
}
