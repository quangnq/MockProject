package fa.training.exception;

public class MockFinalException extends RuntimeException {
    public MockFinalException(Throwable cause) {
        super(cause);
    }

    public MockFinalException(String message) {
        super(message);
    }
}
