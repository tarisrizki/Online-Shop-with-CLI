/**
 * Kelas ini mewarisi dari kelas Pembayaran dan merepresentasikan metode pembayaran melalui transfer bank.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
class Bank extends Pembayaran {
    private String bank;

    //constructor
    public Bank(String bank) {
        this.bank = bank;
    }

    //methote yang dioverride dari class Pembayaran
    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan transfer bank berhasil.");
        System.out.println("Bank: " + bank);
    }
}
