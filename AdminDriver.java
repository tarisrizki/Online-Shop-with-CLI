/**
 * Kelas ini mengelola interaksi admin dengan sistem toko online. Admin dapat menambahkan, menghapus, dan mengedit barang, serta melihat transaksi.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.ArrayList;
import java.util.Scanner;

class AdminDriver extends Driver {
    public Admin akun;
    public ListBarang listBarang;
    public ArrayList<Transaksi> listTransaksi;

    /**
     * Konstruktor untuk membuat objek AdminDriver dengan admin, daftar barang, dan daftar transaksi.
     * 
     * @param akun          Objek Admin yang akan dioperasikan.
     * @param listBarang    Objek ListBarang yang berisi daftar barang.
     * @param listTransaksi ArrayList<Transaksi> yang berisi daftar transaksi.
     */
    public AdminDriver(Admin akun, ListBarang listBarang, ArrayList<Transaksi> listTransaksi) {
        this.akun = akun;
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }

    /**
     * Menampilkan menu admin dan meminta input dari admin untuk melakukan berbagai operasi.
     * 
     * @param scanner Objek Scanner untuk mendapatkan input dari admin.
     */
    public void menuAdmin(Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Edit Barang");
            System.out.println("4. Lihat Transaksi");
            System.out.println("5. Keluar");

            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah nextInt

            switch (choice) {
                case 1:
                    tambahBarang(listBarang, scanner);
                    break;
                case 2:
                    hapusBarang(listBarang, scanner);
                    break;
                case 3:
                    editBarang(listBarang, scanner);
                    break;
                case 4:
                    akun.lihatTransaksi();
                    break;
                case 5:
                    System.out.println("Keluar dari Menu Admin");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 5);
    }

   /**
     * Menambahkan barang baru ke daftar barang menggunakan input dari admin.
     * 
     * @param listBarang Objek ListBarang yang akan diupdate.
     * @param scanner    Objek Scanner untuk mendapatkan input dari admin.
     */
    private void tambahBarang(ListBarang listBarang, Scanner scanner) {
        System.out.print("Masukkan ID Barang: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga Barang: ");
        double harga = scanner.nextDouble();

        Barang newBarang = new Barang(id, nama, harga);
        listBarang.addBarang(newBarang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    /**
     * Menghapus barang dari daftar barang menggunakan input ID dari admin.
     * 
     * @param listBarang Objek ListBarang yang akan diupdate.
     * @param scanner    Objek Scanner untuk mendapatkan input dari admin.
     */
    private void hapusBarang(ListBarang listBarang, Scanner scanner) {
        System.out.print("Masukkan ID Barang yang akan dihapus: ");
        String id = scanner.nextLine();

        // Hapus barang dengan ID yang sesuai
        listBarang.hapusBarang(id);
        System.out.println("Barang berhasil dihapus!");
    }

   /**
     * Mengedit informasi barang dalam daftar menggunakan input ID dari admin.
     * 
     * @param listBarang Objek ListBarang yang akan diupdate.
     * @param scanner    Objek Scanner untuk mendapatkan input dari admin.
     */
    private void editBarang(ListBarang listBarang, Scanner scanner) {
        System.out.print("Masukkan ID Barang yang akan diubah: ");
        String id = scanner.nextLine();

        // Cari barang dengan ID yang sesuai
        Barang barang = listBarang.cariBarang(id);

        if (barang != null) {
            System.out.print("Masukkan Nama Barang baru: ");
            String namaBaru = scanner.nextLine();
            System.out.print("Masukkan Harga Barang baru: ");
            double hargaBaru = scanner.nextDouble();

            // Update informasi barang
            barang.setNama(namaBaru);
            barang.setHarga(hargaBaru);

            System.out.println("Barang berhasil diubah!");
        } else {
            System.out.println("Barang dengan ID tersebut tidak ditemukan.");
        }
    }
}
