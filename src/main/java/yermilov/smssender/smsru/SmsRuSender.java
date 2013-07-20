package yermilov.smssender.smsru;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import yermilov.smssender.SMS;
import yermilov.smssender.SmsSender;

public class SmsRuSender implements SmsSender {
    
    private final static String SMS_RU_SEND_URL = "http://sms.ru/sms/send?api_id={apiId}&to={phoneNumber}&text={text}";
    
    private final static Logger LOG = Logger.getLogger(SmsRuSender.class);
    
    private String apiId;
    private RestTemplate restTemplate;
    
    public void sendSms(SMS sms) {
        LOG.info("Sending SMS: " + sms);
        
        Map<String, String> parameters = new HashMap<>();
        parameters.put("apiId", apiId);
        parameters.put("phoneNumber", sms.getToPhoneNumber());
        parameters.put("text", sms.getText());
        
        restTemplate.postForLocation(SMS_RU_SEND_URL, null, parameters);
    }
    
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
    
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
