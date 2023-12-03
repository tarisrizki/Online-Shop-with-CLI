/**
 * Kelas ini mewarisi dari kelas Akun dan merepresentasikan pelanggan toko online. Pelanggan dapat melihat daftar barang, menambahkan barang ke keranjang, checkout, dan melihat riwayat belanja.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class Customer extends Akun {
    private Keranjang keranjang;
    private List<Transaksi> transaksiSelesai;

    //constructor
    public Customer(String username, String password) {
        super(username, password);
        keranjang = new Keranjang();
        transaksiSelesai = new ArrayList<>();
    }

    //getter
    public List<Transaksi> getTransaksiSelesai() {
        return transaksiSelesai;
    }

    //methode untuk melihat list barang
    public void lihatListBarang(ListBarang listBarang) {
        System.out.println("List Barang yang Dijual:");
        listBarang.displayBarang();
    }

    // Fungsi untuk melihat daftar barang terbaru setelah admin menambahkan barang
    public void lihatDaftarBarangTerbaru(Admin admin, ListBarang listBarang) {
        admin.lihatDaftarBarang(listBarang);
    }

    //methode untuk menambahkan barang ke keranjang
    public void tambahKeKeranjang(Barang barang) {
        keranjang.tambahBarang(barang);
        System.out.println(barang.getNama() + " telah ditambahkan ke keranjang.");
    }

    //methode untuk melakukan checkout
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

    //methode untuk melihat history belanja
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
