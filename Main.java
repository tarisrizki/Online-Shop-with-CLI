import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListBarang listBarang = new ListBarang();
        Admin admin = new Admin("admin", "admin123");

        // Menambahkan beberapa barang contoh
        Barang barang1 = new Barang("001", "Laptop", 8000000);
        Barang barang2 = new Barang("002", "Smartphone", 5000000);
        listBarang.addBarang(barang1);
        listBarang.addBarang(barang2);

        // Membuat akun pelanggan
        Customer customer = new Customer("user1", "user123");

        // Menambahkan pelanggan ke daftar pelanggan admin
        admin.tambahCustomer(customer);

        // Menu Login
        System.out.println("Selamat datang di Online Shop");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (admin.verifyLogin(username, password)) {
            // Admin login
            System.out.println("Admin login berhasil.");
            menuAdmin(admin, listBarang, scanner);
        } else {
            // Pelanggan login
            boolean pelangganLoginBerhasil = false;
            for (Customer c : admin.getDaftarCustomer()) {
                if (c.verifyLogin(username, password)) {
                    System.out.println("Pelanggan login berhasil.");
                    menuPelanggan(c, listBarang, scanner);
                    pelangganLoginBerhasil = true;
                    break;
                }
            }
            if (!pelangganLoginBerhasil) {
                System.out.println("Login gagal. Coba lagi.");
            }
        }
    }

    public static void menuAdmin(Admin admin, ListBarang listBarang, Scanner scanner) {
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
                    admin.lihatTransaksi();
                    break;
                case 5:
                    System.out.println("Keluar dari Menu Admin");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 5);
    }

    private static void tambahBarang(ListBarang listBarang, Scanner scanner) {
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

    private static void hapusBarang(ListBarang listBarang, Scanner scanner) {
        System.out.print("Masukkan ID Barang yang akan dihapus: ");
        String id = scanner.nextLine();

        listBarang.hapusBarang(id);
        System.out.println("Barang berhasil dihapus!");
    }

    private static void editBarang(ListBarang listBarang, Scanner scanner) {
        System.out.print("Masukkan ID Barang yang akan diubah: ");
        String id = scanner.nextLine();

        Barang barang = listBarang.cariBarang(id);

        if (barang != null) {
            System.out.print("Masukkan Nama Barang baru: ");
            String namaBaru = scanner.nextLine();
            System.out.print("Masukkan Harga Barang baru: ");
            double hargaBaru = scanner.nextDouble();

            barang.setNama(namaBaru);
            barang.setHarga(hargaBaru);

            System.out.println("Barang berhasil diubah!");
        } else {
            System.out.println("Barang dengan ID tersebut tidak ditemukan.");
        }
    }

    private static void menuPelanggan(Customer pelanggan, ListBarang listBarang, Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Pelanggan:");
            System.out.println("1. Lihat List Barang");
            System.out.println("2. Tambah ke Keranjang");
            System.out.println("3. Checkout");
            System.out.println("4. Lihat History Belanja");
            System.out.println("5. Keluar");

            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline setelah nextInt

            switch (choice) {
                case 1:
                    pelanggan.lihatListBarang(listBarang);
                    break;
                case 2:
                    System.out.print("Masukkan ID Barang yang ingin ditambahkan ke keranjang: ");
                    String idBarang = scanner.nextLine();
                    Barang barangDitambahkan = listBarang.cariBarang(idBarang);
                    if (barangDitambahkan != null) {
                        pelanggan.tambahKeKeranjang(barangDitambahkan);
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                case 3:
                    // Checkout dengan memilih metode pembayaran
                    pilihMetodePembayaran(pelanggan, scanner);
                    break;
                case 4:
                    pelanggan.lihatHistoryBelanja();
                    break;
                case 5:
                    System.out.println("Keluar dari Menu Pelanggan");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 5);
    }
    
    private static void pilihMetodePembayaran(Customer pelanggan, Scanner scanner) {
        System.out.println("Pilih Metode Pembayaran:");
        System.out.println("1. QRIS Payment");
        System.out.println("2. Bank Transfer");
        System.out.println("3. COD (Cash On Delivery)");
    
        System.out.print("Pilih Metode Pembayaran: ");
        int metodePembayaranChoice = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter newline setelah nextInt
    
        Pembayaran metodePembayaran = null;
    
        switch (metodePembayaranChoice) {
            case 1:
                System.out.print("Masukkan QR Code: ");
                String qrCode = scanner.nextLine();
                metodePembayaran = new QRIS(qrCode);
                break;
            case 2:
                System.out.print("Masukkan Nama Bank: ");
                String bank = scanner.nextLine();
                metodePembayaran = new Bank(bank);
                break;
            case 3:
                metodePembayaran = new COD();
                break;
            default:
                System.out.println("Pilihan Metode Pembayaran tidak valid.");
                break;
        }
    
        if (metodePembayaran != null) {
            pelanggan.checkout(metodePembayaran);
        }
    }
    
}
