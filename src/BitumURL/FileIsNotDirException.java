package BitumURL;

public class FileIsNotDirException extends Exception {
    public FileIsNotDirException() {
        super();
    }

    public FileIsNotDirException(String message) {
        super(message);
    }

    public FileIsNotDirException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIsNotDirException(Throwable cause) {
        super(cause);
    }
}
