/**
 * Kelas ini merupakan kelas untuk objek barang dan semua atributnya
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
class Barang {
    private String id;
    private String nama;
    private double harga;

    /**
     * Konstruktor untuk membuat objek Barang dengan ID, nama, dan harga.
     * 
     * @param id    ID barang.
     * @param nama  Nama barang.
     * @param harga Harga barang.
     */
    public Barang(String id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * Mendapatkan ID barang.
     * 
     * @return String ID barang.
     */
    public String getId() {
        return id;
    }
    /**
     * Mengatur ID barang.
     * 
     * @param id ID barang yang akan diatur.
     */
    public void setId(String id) {
        this.id = id;
    }
     /**
     * Mendapatkan nama barang.
     * 
     * @return String Nama barang.
     */
    public String getNama() {
        return nama;
    }
    /**
     * Mengatur nama barang.
     * 
     * @param nama Nama barang yang akan diatur.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
     /**
     * Mendapatkan harga barang.
     * 
     * @return double Harga barang.
     */
    public double getHarga() {
        return harga;
    }
    /**
     * Mengatur harga barang.
     * 
     * @param harga Harga barang yang akan diatur.
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }

    /**
     * Menghasilkan representasi string dari objek Barang.
     * 
     * @return String Representasi string objek Barang.
     */
    @Override
    public String toString() {
        return "[" + id + "] " + nama + " - Rp" + harga;
    }
}
