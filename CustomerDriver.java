import java.util.Scanner;

public class CustomerDriver extends Driver {
    public Customer akun;
    public Transaksi transaksi;
    public ListBarang barang;

    public void menuPelanggan(Customer pelanggan, ListBarang listBarang, Scanner scanner) {
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
            System.out.println();

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

    public void pilihMetodePembayaran(Customer pelanggan, Scanner scanner) {
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