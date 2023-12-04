/**
 * Kelas ini adalah kelas dasar yang merepresentasikan akun dengan menyimpan informasi dasar seperti username dan password.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
abstract class Akun {
    private String username;
    private String password;

     /**
     * Konstruktor untuk membuat objek Akun dengan username dan password.
     * 
     * @param username Username untuk akun.
     * @param password Password untuk akun.
     */
    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Memverifikasi login dengan membandingkan username dan password yang dimasukkan dengan informasi akun.
     * 
     * @param inputUsername Username yang dimasukkan untuk login.
     * @param inputPassword Password yang dimasukkan untuk login.
     * @return true jika login berhasil, false jika gagal.
     */
    public boolean verifyLogin(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

   /**
     * Mendapatkan username dari akun.
     * 
     * @return String Username akun.
     */
    public String getUsername() {
        return username;
    }
}
