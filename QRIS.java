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
