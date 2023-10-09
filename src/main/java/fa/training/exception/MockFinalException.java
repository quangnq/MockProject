package fa.training.exception;

/**
 * Lớp {@code MockFinalException} là một loại ngoại lệ (exception) tùy chỉnh (custom exception) được sử dụng
 * để đại diện cho các trường hợp ngoại lệ trong ứng dụng. Lớp này có thể được sử dụng để bắt các trường hợp
 * ngoại lệ cụ thể hoặc truyền thông tin cụ thể trong các tình huống ngoại lệ.
 *
 * @see RuntimeException
 * @version 1.0
 * @since 1 thg 10, 2023
 */
public class MockFinalException extends RuntimeException {
    public MockFinalException(Throwable cause) {
        super(cause);
    }

    public MockFinalException(String message) {
        super(message);
    }
}
