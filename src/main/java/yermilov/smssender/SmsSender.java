package yermilov.smssender;

/**
 * General interface for sending SMS messages.
 * 
 * @author yaroslav.yermilov
 */
public interface SmsSender {

    /**
     * Send passed SMS message.
     * @param smsMessage message to send.
     * @throws SmsSenderException if something goes wrong.
     */
    void sendMessage(SmsMessage smsMessage) throws SmsSenderException;
}
