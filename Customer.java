import java.util.ArrayList;
import java.util.List;

class Customer extends Akun {
    private Keranjang keranjang;
    private List<Transaksi> transaksiSelesai;

    public Customer(String username, String password) {
        super(username, password);
        keranjang = new Keranjang();
        transaksiSelesai = new ArrayList<>();
    }

    public List<Transaksi> getTransaksiSelesai() {
        return transaksiSelesai;
    }

    public void lihatListBarang(ListBarang listBarang) {
        System.out.println("List Barang yang Dijual:");
        listBarang.displayBarang();
    }

    // Fungsi untuk melihat daftar barang terbaru setelah admin menambahkan barang
    public void lihatDaftarBarangTerbaru(Admin admin, ListBarang listBarang) {
        admin.lihatDaftarBarang(listBarang);
    }

    public void tambahKeKeranjang(Barang barang) {
        keranjang.tambahBarang(barang);
        System.out.println(barang.getNama() + " telah ditambahkan ke keranjang.");
    }

    public void checkout(Pembayaran metodePembayaran) {
        List<Barang> barangDibeli = keranjang.getListBarang();
        if (barangDibeli.isEmpty()) {
            System.out.println("Keranjang kosong. Tidak dapat checkout.");
        } else {
            Transaksi transaksi = new Transaksi(new ArrayList<>(barangDibeli), metodePembayaran);
            transaksiSelesai.add(transaksi);
            keranjang.clearKeranjang();
            System.out.println("Checkout berhasil. Terima kasih atas pembelian Anda!");
            System.out.println("Metode Pembayaran: " + metodePembayaran.getClass().getSimpleName());
        }
    }

    public void lihatHistoryBelanja() {
        System.out.println("History Belanja:");
        for (Transaksi transaksi : transaksiSelesai) {
            System.out.println("Transaksi ID: " + transaksi.getId());
            System.out.println("Barang yang dibeli:");
            for (Barang barang : transaksi.getDaftarBarang()) {
                System.out.println("  - " + barang.getNama());
            }
            System.out.println("---------------------------");
        }
    }
}
