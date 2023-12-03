/**
 * Kelas ini mewarisi dari kelas Akun dan merepresentasikan admin toko online. Admin dapat menambahkan pelanggan, melihat transaksi, dan melihat daftar barang.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class Admin extends Akun {
    private List<Customer> daftarCustomer;

    //constructor
    public Admin(String username, String password) {
        super(username, password);
        daftarCustomer = new ArrayList<>();
    }

    //methode untuk menambah customer
    public void tambahCustomer(Customer customer) {
        daftarCustomer.add(customer);
    }

    //methode getter
    public List<Customer> getDaftarCustomer() {
        return daftarCustomer;
    }

    //methode untuk melihat daftar transaksi
    public void lihatTransaksi() {
        System.out.println("Daftar Transaksi:");
        for (Customer customer : daftarCustomer) {
            List<Transaksi> transaksiSelesai = customer.getTransaksiSelesai();
            if (!transaksiSelesai.isEmpty()) {
                System.out.println("Transaksi untuk Pelanggan " + customer.getUsername() + ":");
                for (Transaksi transaksi : transaksiSelesai) {
                    System.out.println("Transaksi ID: " + transaksi.getId());
                    System.out.println("Barang yang dibeli:");
                    for (Barang barang : transaksi.getDaftarBarang()) {
                        System.out.println("  - " + barang.getNama());
                    }
                    System.out.println("Metode Pembayaran: " + transaksi.getMetodePembayaran().getClass().getSimpleName());
                    System.out.println("---------------------------");
                }
            } else {
                System.out.println("Belum ada transaksi untuk Pelanggan " + customer.getUsername());
            }
        }
    }

    //methode untuk melihat daftar barang
    public void lihatDaftarBarang(ListBarang listBarang) {
        System.out.println("Daftar Barang Terbaru:");
        listBarang.displayBarang();
    }
}
