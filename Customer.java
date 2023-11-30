import java.util.ArrayList;

public class Customer extends Akun {
    public Keranjang keranjang;
    public ArrayList<Invoice> invoiceSelesai;

    public Customer(String username, String password) {
        super(username, password);
        this.keranjang = new Keranjang();
        this.invoiceSelesai = new ArrayList<>();
    }
}