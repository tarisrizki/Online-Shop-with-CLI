/**
 * Kelas ini mewarisi dari kelas Pembayaran dan merepresentasikan metode pembayaran melalui transfer bank.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
class Bank extends Pembayaran {
    private String bank;

    /**
     * Konstruktor untuk membuat objek Bank dengan nama bank.
     * 
     * @param bank Nama bank untuk metode pembayaran transfer bank.
     */
    public Bank(String bank) {
        this.bank = bank;
    }

    /**
     * Mengimplementasikan proses pembayaran menggunakan metode transfer bank.
     * 
     * @param total Jumlah total yang harus dibayar.
     */
    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan transfer bank berhasil.");
        System.out.println("Bank: " + bank);
    }
}
