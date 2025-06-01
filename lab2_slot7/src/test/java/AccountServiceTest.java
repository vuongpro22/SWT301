import static org.junit.jupiter.api.Assertions.*;

import binhvuong.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AccountServiceTest {

    AccountService service = new AccountService();
//    @ParameterizedTest
//    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
//    void testIsValidEmail(String username, String password, String email, boolean expected) {
//        boolean isValid = service.isValidEmail(email);
//        if (email.contains("@") && email.contains(".")) {
//            assertTrue(isValid || !expected, "Expected valid email: " + email);
//        } else {
//            assertFalse(isValid, "Expected invalid email: " + email);
//        }
//    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean result = service.registerAccount(username, password, email);
        assertEquals(expected, result,
                String.format("username=%s, password=%s, email=%s", username, password, email));
    }
//
//
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
//    void testIsValidPassword(String username, String password, String email, boolean expected) {
//        boolean isValid = service.isValidPassword(password);
//        if (password != null && password.length() > 6) {
//            assertTrue(isValid || !expected, "Expected valid password: " + password);
//        } else {
//            assertFalse(isValid, "Expected invalid password: " + password);
//        }
//    }
//    @ParameterizedTest
//    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
//    void testIsValidUsername(String username, String password, String email, boolean expected) {
//        boolean isValid = service.isValidUsername(username);
//        if(username != null&&username.matches("^[a-zA-Z0-9]+$")){
//            assertTrue(isValid || !expected, "Expected valid username: " + username);
//        }else {
//            assertFalse(isValid, "Expected invalid password: " + username);
//        }
//    }

}
