package Exception;

public class MiniException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    public MiniException() {
        super();
    }

    public MiniException(String message) {
        super(message);
        this.errorMsg = message;
    }

    public MiniException(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;

    }
}