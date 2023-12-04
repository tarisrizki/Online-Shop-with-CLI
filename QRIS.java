/**
 * Kelas ini mewarisi dari kelas Pembayaran dan merepresentasikan metode pembayaran dengan QRIS.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
class QRIS extends Pembayaran {
    private String qrCode;
    /**
     * Konstruktor untuk membuat objek QRIS dengan QR Code tertentu.
     * 
     * @param qrCode String QR Code untuk metode pembayaran QRIS.
     */
    public QRIS(String qrCode) {
        this.qrCode = qrCode;
    }
    /**
     * Metode yang dioverride dari kelas Pembayaran untuk melakukan proses pembayaran dengan QRIS.
     * 
     * @param total Jumlah total pembayaran.
     */
    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan QRIS berhasil.");
        System.out.println("QR Code: " + qrCode);
    }
}
