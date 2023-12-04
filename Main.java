/**
 * Kelas ini berisi metode main sebagai titik masuk program utama. Digunakan untuk inisialisasi dan pengaturan awal toko online.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
  /**
     * Metode main sebagai titik masuk program utama.
     * 
     * @param args Argumen dari command line.
     */
    public static void main(String[] args) {
        boolean program = true;
        Admin admin = new Admin("admin", "admin123");

        ListBarang listBarang = new ListBarang();

        // Menambahkan beberapa barang contoh
        Barang barang1 = new Barang("001", "Laptop", 8000000);
        Barang barang2 = new Barang("002", "Smartphone", 5000000);
        listBarang.addBarang(barang1);
        listBarang.addBarang(barang2);

        // Membuat akun pelanggan
        Customer customer = new Customer("user1", "user123");

        // Menambahkan pelanggan ke daftar pelanggan admin
        admin.tambahCustomer(customer);

        while (program) {
            
            // Menambahkan pelanggan ke daftar pelanggan admin
            System.out.println("===============================");
            System.out.println("Selamat datang di Online Shop");
            // System.out.println("Apakah anda sudah memiliki akun?");
            System.out.println("Ingin Login sebagai apa?");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            System.out.println("===============================\n");
            switch (pilihan) {
                case 1:
                    Driver.login(admin, listBarang);
                    break;
                case 2:
                    Driver.login(admin, listBarang);
                    break;
                case 3:
                    program = false;
            default:
                break;
            }
        }
    }
}
    

