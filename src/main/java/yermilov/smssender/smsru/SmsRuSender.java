package yermilov.smssender.smsru;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import yermilov.smssender.SmsMessage;
import yermilov.smssender.SmsSender;
import yermilov.smssender.SmsSenderException;

/**
 * Uses <a href='http://sms.ru'>sms.ru</a> service to send SMS messages. <br/>
 * Mandatory parameter apiId should be injected. 
 * It can be found <a href='http://sms.ru/?panel=settings&subpanel=api'>here</a>. <br/>
 * {@link RestTemplate} can be either injected, or otherwise new instance will be created.
 * 
 * @author yaroslav.yermilov
 */
public class SmsRuSender implements SmsSender {
    
    private final static String SMS_RU_SEND_URL = "http://sms.ru/sms/send?api_id={apiId}&to={phoneNumber}&text={text}";
    
    private final static Logger LOG = Logger.getLogger(SmsRuSender.class);
    
    private String apiId;
    private RestTemplate restTemplate;
    
    @Override
    public void sendMessage(SmsMessage smsMessage) throws SmsSenderException {
        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("apiId", apiId);
            parameters.put("phoneNumber", smsMessage.getToPhoneNumber());
            parameters.put("text", smsMessage.getText());
            
            ensureRestTemplateWasInjected();
            
            restTemplate.postForLocation(SMS_RU_SEND_URL, null, parameters);
            
            LOG.info("Send SMS message: " + smsMessage);
        } catch (RestClientException e) {
            LOG.error("Can't send SMS message", e);
            throw new SmsSenderException("Can't send SMS message", e);
        }
    }
    
    private void ensureRestTemplateWasInjected() {
        if (restTemplate == null) {
            LOG.warn("REST template wasn't injected. Will create new instance.");
            restTemplate = new RestTemplate();
        }
    }

    /**
     * Mandatory parameter apiId should be injected. 
     * @param apiId can be found <a href='http://sms.ru/?panel=settings&subpanel=api'>here</a>.
     */
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
    
    /**
     * Can be either injected, or otherwise new instance will be created.
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
