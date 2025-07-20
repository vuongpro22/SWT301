package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("✅ Đăng ký thành công với đầy đủ thông tin")
    void testFullRegistration() {
        RegistrationPage page = new RegistrationPage(driver);
        page.navigate();

        page.fillBasicInfo("Nguyen", "binhvuong", "binhvuong@example.com", "0912345678");
        page.setDateOfBirth("20 Jul 2000");
        page.selectSubject("Math");
        page.selectHobbyMusic();
        page.fillAddress("123 ABC Street, Hanoi");
        page.submitForm();

        assertTrue(page.isConfirmationPopupVisible(), "❌ Không hiển thị popup xác nhận");
    }



    @Test
    @DisplayName("❌ Lỗi khi thiếu số điện thoại")
    void testMissingPhone() {
        RegistrationPage page = new RegistrationPage(driver);
        page.navigate();

        page.fillBasicInfo("Nguyen", "binhvuong", "binhvuong@example.com", "");
        page.submitForm();

        assertFalse(page.isConfirmationPopupVisible(), "❌ Popup xuất hiện dù thiếu số điện thoại");
    }

    @Test
    @DisplayName("❌ Lỗi khi nhập email sai định dạng")
    void testInvalidEmailFormat() {
        RegistrationPage page = new RegistrationPage(driver);
        page.navigate();

        page.fillBasicInfo("Nguyen", "binhvuong", "binhvuongexample.com", "0912345678");
        page.submitForm();

        assertFalse(page.isConfirmationPopupVisible(), "❌ Popup xuất hiện dù email sai");
    }

    @Test
    @DisplayName("❌ Lỗi khi không chọn giới tính")
    void testMissingGender() {
        RegistrationPage page = new RegistrationPage(driver);
        page.navigate();

        // Không click giới tính
        page.typeFirstName("Nguyen");
        page.typeLastName("binhvuong");
        page.typeEmail("binhvuong@example.com");
        page.typePhone("0912345678");

        page.submitForm();

        assertFalse(page.isConfirmationPopupVisible(), "❌ Popup xuất hiện dù chưa chọn giới tính");
    }

    @Test
    @DisplayName("❌ Lỗi khi thiếu họ tên")
    void testMissingName() {
        RegistrationPage page = new RegistrationPage(driver);
        page.navigate();

        page.fillBasicInfo("", "", "binhvuong@example.com", "0912345678");
        page.submitForm();

        assertFalse(page.isConfirmationPopupVisible(), "❌ Popup xuất hiện dù thiếu họ tên");
    }

}
