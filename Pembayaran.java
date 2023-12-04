/**
 * Kelas abstrak ini merepresentasikan metode pembayaran dan memiliki metode abstrak 
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
abstract class Pembayaran {
     /**
     * Metode abstrak untuk melakukan proses pembayaran dengan total tertentu.
     * 
     * @param total Jumlah total pembayaran.
     */
    public abstract void prosesPembayaran(double total);
}
