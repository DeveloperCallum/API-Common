package common.account;

public class AccountBasicInfo {
    private String username;
    private String password;

    private AccountBasicInfo() {
    }

    public AccountBasicInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
