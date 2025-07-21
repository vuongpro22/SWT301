package tests;

import org.junit.jupiter.api.Test;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegisterTest extends BaseTest {
    @Test
    void testRegisterValidUser() {
        RegisterPage page = new RegisterPage(driver);
        page.navigate();
        page.register("vuong123", "vuong@gmail.com", "12345678");
        assertTrue(page.isSuccessDisplayed());
    }
//    @Test
//    void testEmptyUsername() {
//        RegisterPage page = new RegisterPage(driver);
//        page.navigate();
//        page.register("", "vuong@gmail.com", "12345678");
//        assertFalse(page.isSuccessDisplayed());
//    }
//
//    @Test
//    void testInvalidEmailFormat() {
//        RegisterPage page = new RegisterPage(driver);
//        page.navigate();
//        page.register("vuong123", "vuong-at-gmail.com", "12345678");
//        assertFalse(page.isSuccessDisplayed());
//    }
//
//    @Test
//    void testShortPassword() {
//        RegisterPage page = new RegisterPage(driver);
//        page.navigate();
//        page.register("vuong123", "vuong@gmail.com", "123");  // < 6 ký tự
//        assertFalse(page.isSuccessDisplayed());
//    }
//
//    @Test
//    void testEmptyAllFields() {
//        RegisterPage page = new RegisterPage(driver);
//        page.navigate();
//        page.register("", "", "");
//        assertFalse(page.isSuccessDisplayed());
//    }

}
