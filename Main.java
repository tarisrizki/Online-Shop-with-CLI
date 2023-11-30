import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi list barang
        ListBarang listBarang = new ListBarang();
        // Inisialisasi list transaksi
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();

        // Membuat beberapa barang contoh
        // Barang barang1 = new Barang("001", "Laptop", 8000000);
        // Barang barang2 = new Barang("002", "Smartphone", 5000000);
        // listBarang.addBarang(barang1);
        // listBarang.addBarang(barang2);
        
        // Membuat akun admin
        Admin admin = new Admin("admin", "admin123");

        // Membuat akun costumer
        Customer customer = new Customer("Naufal", "naufal123");

        // Membuat objek admin driver
        AdminDriver adminDriver = new AdminDriver(admin, listBarang, listTransaksi);

        // Menampilkan menu login
        login(adminDriver, scanner);
    }

    public static void login(AdminDriver adminDriver, Scanner scanner) {
        System.out.println("Login:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin")) {
            // Verifikasi login admin
            if (adminDriver.akun.verifyLogin(username, password)) {
                System.out.println("Login berhasil!");
                // Pemanggilan fungsi atau menu admin setelah login
                adminDriver.menuAdmin(scanner);
            } else {
                System.out.println("Login gagal. Coba lagi.");
                // Pemanggilan kembali fungsi login jika login gagal
                login(adminDriver, scanner);
            }
        } else {
            
        }
    }
}