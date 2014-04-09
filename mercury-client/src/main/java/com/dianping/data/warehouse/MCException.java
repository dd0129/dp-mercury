package com.dianping.data.warehouse;

/**
 * @Author <a href="mailto:tsensue@gmail.com">dishu.chen</a>
 * 14-2-26.
 */
public class MCException extends Exception {
    public MCException() {
        super();
    }

    public MCException(String message) {
        super(message);
    }

    public MCException(String message, Throwable cause) {
        super(message, cause);
    }

    public MCException(Throwable cause) {
        super(cause);
    }
}
