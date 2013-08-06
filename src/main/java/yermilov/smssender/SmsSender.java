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
     */
    void sendMessage(SmsMessage smsMessage);
}
