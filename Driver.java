/**
 * Kelas ini mengelola login yang dilakukan baik dari user ataupun admin
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
import java.util.Scanner;

public class Driver {
    //methode untuk login
    public static void login(Admin admin, ListBarang listBarang) {
        Scanner scanner = new Scanner(System.in);
        try {//exeption handling
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
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat membaca input.");
            e.printStackTrace(); // Tangani exception dengan tepat di aplikasi nyata.
        }
    }
    
}
