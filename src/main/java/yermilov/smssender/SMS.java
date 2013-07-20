package yermilov.smssender;

public class SMS {
    
    private String toPhoneNumber;
    private String text;
    
    public SMS(String toPhoneNumber, String text) {
        this.toPhoneNumber = toPhoneNumber;
        this.text = text;
    }

    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public String getText() {
        return text;
    }
    
    @Override
    public String toString() {
        return "to: [" + toPhoneNumber + "]; text: [" + text + "]";
    }
}
