import java.util.ArrayList;
import java.util.Scanner;

public class AdminDriver extends Driver {
    public Admin akun;
    public ListBarang listBarang;
    public ArrayList<Transaksi> listTransaksi;

    public AdminDriver(Admin akun, ListBarang listBarang, ArrayList<Transaksi> listTransaksi) {
        this.akun = akun;
        this.listBarang = listBarang;
        this.listTransaksi = listTransaksi;
    }

    // Fungsi atau menu admin
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
                    tambahBarang(scanner);
                    break;
                case 2:
                    hapusBarang(scanner);
                    break;
                case 3:
                    editBarang(scanner);
                    break;
                case 4:
                    lihatTransaksi();
                    break;
                case 5:
                    System.out.println("Keluar dari Menu Admin");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 5);
    }

    private void tambahBarang(Scanner scanner) {
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

    private void hapusBarang(Scanner scanner) {
        System.out.print("Masukkan ID Barang yang akan dihapus: ");
        String id = scanner.nextLine();

        // Hapus barang dengan ID yang sesuai
        listBarang.hapusBarang(id);
        System.out.println("Barang berhasil dihapus!");
    }

    private void editBarang(Scanner scanner) {
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

    private void lihatTransaksi() {
        // Tampilkan list transaksi yang ada
        for (Transaksi transaksi : listTransaksi) {
            System.out.println("Transaksi ID: " + transaksi.getId());
            // Tampilkan informasi tambahan sesuai kebutuhan
        }
    }
}