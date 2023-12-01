class COD extends Pembayaran {
    @Override
    public void prosesPembayaran(double total) {
        System.out.println("Pembayaran sebesar Rp" + total + " dengan metode COD berhasil.");
        System.out.println("Silakan bayar tunai saat barang diterima.");
    }
}

