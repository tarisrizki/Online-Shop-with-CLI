/**
 * Kelas ini adalah kelas dasar yang merepresentasikan akun dengan menyimpan informasi dasar seperti username dan password.
 * @author Naufal Aqil, M. Taris Riski, Zuwi Pertiwi
 * @version 04/12/2023
 */
abstract class Akun {
    private String username;
    private String password;

    //constructor
    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //methode untuk menverifikasi login yang masuk
    public boolean verifyLogin(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    //getter
    public String getUsername() {
        return username;
    }
}
