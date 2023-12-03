import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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
            System.out.println("Apakah anda sudah memiliki akun?");
            System.out.println("Jika sudah tekan 1 untuk login dan jika belum tekan 2 untuk sign up");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            System.out.println("===============================\n");
            switch (pilihan) {
                case 1:
                login(admin, listBarang);
                break;
                case 2:
                signUp(admin, scanner, null);
                break;
                case 3:
                program = false;
            default:
                break;
            }
        }
    }
        
        // Menu Login
        public static void login(Admin admin, ListBarang listBarang){
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (admin.verifyLogin(username, password)) {
            // Admin login
            System.out.println("Admin login berhasil.");
            AdminDriver adminDriver = new AdminDriver(admin, listBarang, null);
            adminDriver.menuAdmin(scanner);
        } else {
            // Pelanggan login
            boolean pelangganLoginBerhasil = false;
            for (Customer c : admin.getDaftarCustomer()) {
                if (c.verifyLogin(username, password)) {
                    CustomerDriver customerDriver = new CustomerDriver();
                    customerDriver.menuPelanggan(c, listBarang, scanner);
                    pelangganLoginBerhasil = true;
                    break;
                }
            }
            if (!pelangganLoginBerhasil) {
                System.out.println("Login gagal. Coba lagi.");
            }
        }
    }

    //signup
    public static void signUp(Admin admin, Scanner scanner, Customer pelanggan) {
        System.out.println("Customer Signup:");
        System.out.print("Masukkan username anda: ");
        String usernamePelanggan = scanner.nextLine();
        System.out.print("Masukkan password anda: ");
        String passwordPelanggan = scanner.nextLine();

        pelanggan = new Customer(usernamePelanggan, passwordPelanggan);
        admin.tambahCustomer(pelanggan);

        System.out.println("Customer account berhasil dibuat.");
        login(admin, null);
    }
}
    

