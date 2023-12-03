/**
 * Kelas ini mewarisi dari kelas Pembayaran dan merepresentasikan metode pembayaran Cash On Delivery (COD).
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
class COD extends Pembayaran {
    //methode yang di override dari class Pembayaran
    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan metode COD berhasil.");
        System.out.println("Silakan bayar tunai saat barang diterima.");
    }
}

