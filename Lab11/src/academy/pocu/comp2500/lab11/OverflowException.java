package academy.pocu.comp2500.lab11;

public final class OverflowException extends RuntimeException {
    public OverflowException() {
        super();
    }

    public OverflowException(String msg) {
        super(msg);
    }

    public OverflowException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
