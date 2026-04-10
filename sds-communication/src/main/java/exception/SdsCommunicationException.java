package exception;

/**
 * @author Joseph.Kibe. Created On 11 Apr 2026 02:55
 */
public class SdsCommunicationException extends RuntimeException {
    public SdsCommunicationException(String message) {
        super(message);
    }

    public SdsCommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
