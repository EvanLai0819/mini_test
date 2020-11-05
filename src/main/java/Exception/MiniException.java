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

    public MiniException(String retCd, String msgDes) {
        super();
        this.errorCode = retCd;
        this.errorMsg = msgDes;
    }

    public String getRetCd() {
        return this.errorCode;
    }

    public String getMsgDes() {
        return this.errorMsg;

    }
}