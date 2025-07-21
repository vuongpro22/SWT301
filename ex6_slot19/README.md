# Selenium Test Project - Exercise 6

## Mô tả
Project này chứa các test case Selenium cho chức năng đăng ký và quản lý profile.

## Cấu trúc Project
```
ex6_slot19/
├── src/
│   ├── main/java/
│   └── test/java/
│       ├── pages/
│       │   ├── BasePage.java
│       │   ├── RegisterPage.java
│       │   └── ProfilePage.java
│       ├── tests/
│       │   ├── BaseTest.java
│       │   ├── RegisterTest.java
│       │   ├── ProfileTest.java
│       │   └── AllTests.java
│       └── utils/
│           └── DriverFactory.java
├── index.html (Registration form)
├── index2.html (Profile management)
└── pom.xml
```

## Cách chạy test

### 1. Khởi động Web Server
Trước khi chạy test, bạn cần khởi động web server để phục vụ các file HTML:

```bash
cd ex6_slot19
python -m http.server 5500
```

### 2. Chạy Test Cases

#### Chạy tất cả test:
```bash
mvn test
```

#### Chạy test đăng ký:
```bash
mvn test -Dtest=RegisterTest
```

#### Chạy test profile:
```bash
mvn test -Dtest=ProfileTest
```

#### Chạy tất cả test với mô tả:
```bash
mvn test -Dtest=AllTests
```

## Test Cases

### RegisterTest
**Valid Cases:**
- `testRegisterValidUser()` - Đăng ký với dữ liệu hợp lệ

**Invalid Cases:**
- `testRegisterWithEmptyUsername()` - Đăng ký với username rỗng
- `testRegisterWithEmptyEmail()` - Đăng ký với email rỗng
- `testRegisterWithEmptyPassword()` - Đăng ký với password rỗng
- `testRegisterWithInvalidEmail()` - Đăng ký với email không hợp lệ
- `testRegisterWithShortPassword()` - Đăng ký với password quá ngắn
- `testRegisterWithSpecialCharactersInUsername()` - Đăng ký với username có ký tự đặc biệt

### ProfileTest
**Valid Cases:**
- `testUpdateProfileName()` - Cập nhật tên profile hợp lệ
- `testUploadAvatar()` - Upload ảnh avatar hợp lệ

**Invalid Cases:**
- `testUpdateProfileWithEmptyName()` - Cập nhật với tên rỗng
- `testUpdateProfileWithOnlySpaces()` - Cập nhật với tên chỉ có khoảng trắng
- `testUpdateProfileWithVeryLongName()` - Cập nhật với tên quá dài
- `testUpdateProfileWithSpecialCharacters()` - Cập nhật với tên có ký tự đặc biệt
- `testUploadNonImageFile()` - Upload file không phải ảnh
- `testUploadNonExistentFile()` - Upload file không tồn tại
- `testUpdateProfileWithoutClickingSave()` - Cập nhật mà không click save

## Validation Rules

### Registration Form (index.html)
- Username: Không rỗng, tối đa 20 ký tự, chỉ chấp nhận chữ cái, số và dấu gạch dưới
- Email: Định dạng email hợp lệ
- Password: Tối thiểu 6 ký tự

### Profile Form (index2.html)
- Name: Không rỗng, tối đa 50 ký tự, chỉ chấp nhận chữ cái và khoảng trắng
- Avatar: Chỉ chấp nhận file ảnh

## Dependencies
- Selenium WebDriver 4.21.0
- JUnit Jupiter 5.10.2
- WebDriverManager 5.7.0

## Lưu ý
- Đảm bảo web server đang chạy trên port 5500 trước khi chạy test
- File ảnh test: `src/test/resources/IMG_9688.JPEG`
- Test sẽ tự động mở và đóng trình duyệt Chrome cho mỗi test case 