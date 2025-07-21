package tests;

import org.junit.jupiter.api.Test;
import pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest extends BaseTest {
    @Test
    void testUpdateProfileName() {
        ProfilePage page = new ProfilePage(driver);
        page.navigate();
        page.updateName("vuong");
        assertTrue(page.isProfileUpdated());
    }

    @Test
    void testUploadAvatar() {
        ProfilePage page = new ProfilePage(driver);
        page.navigate();
        page.uploadAvatar("D:\\SU25\\SWT301\\SWT301\\ex6_slot19\\src\\test\\resources\\IMG_9688.JPEG");
        assertTrue(page.isProfileUpdated());
    }
}
