package saleManagement.Model;

public class LoginModel{
    private String account, password;
    public LoginModel(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public String getPassword() {
        return this.password;
    }
}
