public class Admin extends Akun {
    private List<Customer> daftarCustomer;
    
    public Admin(String username, String password) {
        super(username, password);
         daftarCustomer = new ArrayList<>();
    }

    public void tambahCustomer(Customer customer) {
        daftarCustomer.add(customer);
    }

    public List<Customer> getDaftarCustomer() {
        return daftarCustomer;
    }

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

    public void lihatDaftarBarang(ListBarang listBarang) {
        System.out.println("Daftar Barang Terbaru:");
        listBarang.displayBarang();
    }
}
