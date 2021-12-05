package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    private static final long serialVersionUID = 94l;

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
