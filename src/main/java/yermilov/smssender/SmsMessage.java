package yermilov.smssender;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Data object for SMS message.
 * Can be constructed using {@link Builder}.
 * 
 * @author yaroslav.yermilov
 */
public class SmsMessage {
    
    private String toPhoneNumber;
    private String text;

    /**
     * @return destination phone number
     */
    public String getToPhoneNumber() {
        return toPhoneNumber;
    }
    
    /**
     * @param toPhoneNumber destination phone number
     */
    public void setToPhoneNumber(String toPhoneNumber) {
        this.toPhoneNumber = toPhoneNumber;
    }

    /**
     * @return message text
     */
    public String getText() {
        return text;
    }
    
    /**
     * @param text message text
     */
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    /**
     * Builder for {@link SmsMessage}
     * 
     * @author yaroslav.yermilov
     */
    public final static class Builder {
        
        private String toPhoneNumber;
        private String text;
        
        private Builder() {}
        
        /**
         * Starts creation of new SMS message
         */
        public static Builder newSms() {
            return new Builder();
        }
        
        /**
         * Finishes creation of new SMS message
         * @return constructed {@link SmsMessage} instance
         */
        public SmsMessage build() {
            validate();
            normalize();
            
            SmsMessage result = new SmsMessage();
            result.setToPhoneNumber(toPhoneNumber);
            result.setText(text);
            
            return result;
        }

        // validates message attributes
        private void validate() {
            if (toPhoneNumber == null) {
                throw new IllegalArgumentException("Phone number should be specified");
            }
        }
        
        // fixes possible unappropriated message attributes
        private void normalize() {
            if (text == null) {
                text = "";
            }
        }

        /**
         * @param toPhoneNumber destination phone number
         */
        public Builder to(String toPhoneNumber) {
            this.toPhoneNumber = toPhoneNumber;
            return this;
        }
        
        /**
         * @param text message text
         */
        public Builder withMessage(String text) {
            this.text = text;
            return this;
        }
    }
}
