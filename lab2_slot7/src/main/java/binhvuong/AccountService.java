package binhvuong;

public class AccountService {
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }
    public boolean isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9]+$");
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.trim().isEmpty()) return false;
        if (!isValidPassword(password)) return false;
        if (!isValidEmail(email)) return false;
        if(!isValidUsername(username)) return false;
        return true;
    }
}
