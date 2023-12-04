/**
 * Kelas ini mewarisi dari kelas Akun dan merepresentasikan admin toko online. Admin dapat menambahkan pelanggan, melihat transaksi, dan melihat daftar barang.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.List;

class Admin extends Akun {
    private List<Customer> daftarCustomer;

    /**
     * Konstruktor untuk membuat objek Admin dengan username dan password.
     * 
     * @param username Username admin.
     * @param password Password admin.
     */
    public Admin(String username, String password) {
        super(username, password);
        daftarCustomer = new ArrayList<>();
    }

    /**
     * Menambahkan customer baru ke daftar customer admin.
     * 
     * @param customer Objek Customer yang akan ditambahkan.
     */
    public void tambahCustomer(Customer customer) {
        daftarCustomer.add(customer);
    }

    /**
     * Mendapatkan daftar customer yang dimiliki oleh admin.
     * 
     * @return List<Customer> Daftar customer admin.
     */
    public List<Customer> getDaftarCustomer() {
        return daftarCustomer;
    }

   /**
     * Menampilkan daftar transaksi yang telah selesai untuk setiap pelanggan.
     */
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

     /**
     * Menampilkan daftar barang terbaru dari objek ListBarang.
     * 
     * @param listBarang Objek ListBarang yang berisi daftar barang.
     */
    public void lihatDaftarBarang(ListBarang listBarang) {
        System.out.println("Daftar Barang Terbaru:");
        listBarang.displayBarang();
    }
}
