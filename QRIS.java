/**
 * Kelas ini mewarisi dari kelas Pembayaran dan merepresentasikan metode pembayaran dengan QRIS.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
class QRIS extends Pembayaran {
    private String qrCode;

    public QRIS(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan QRIS berhasil.");
        System.out.println("QR Code: " + qrCode);
    }
}
