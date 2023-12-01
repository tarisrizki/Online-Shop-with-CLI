public abstract class Akun {
    public String username;
    public String password;

    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verifyLogin(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

     public String getUsername() {
        return username;
    }
}
