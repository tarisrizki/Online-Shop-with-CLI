public class Bank extends Pembayaran{
    public void String bank;

    public Bank(String bank) {
        this.bank = bank;
    }

    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan transfer bank berhasil.");
        System.out.println("Bank: " + bank);
    }
}
