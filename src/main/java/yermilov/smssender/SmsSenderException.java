package yermilov.smssender;

/**
 * General exception that indicates that something goes wrong during sending SMS message.
 * 
 * @author yaroslav.yermilov
 */
public class SmsSenderException extends RuntimeException {
    
    private static final long serialVersionUID = -4008513589245842035L;

    public SmsSenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
