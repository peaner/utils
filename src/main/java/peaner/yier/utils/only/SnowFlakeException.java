package peaner.yier.utils.only;

/**
 * @author: Peaner
 * @time: 2020/11/23
 * @description:
 */
public class SnowFlakeException extends RuntimeException {

    private int code;

    public SnowFlakeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public SnowFlakeException() {
        super();
    }

    public SnowFlakeException(String message) {
        super(message);
    }

    public SnowFlakeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SnowFlakeException(Throwable cause) {
        super(cause);
    }

    protected SnowFlakeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return code;
    }


}
