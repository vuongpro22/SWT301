package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");   // mở trình duyệt full màn hình
        options.addArguments("--incognito");         // chế độ ẩn danh, tránh cache
        options.addArguments("--disable-notifications"); // tắt thông báo trình duyệt

        return new ChromeDriver(options);
    }
}
