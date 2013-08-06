sms-sender
==========

Library to organize programming sending SMS messages.

## Implementations

For now, the only supported implementation is [sms.ru](http://sms.ru/) service.

### sms.ru

For more information visit [service homepage](http://sms.ru/).
The main idea is that to use it, one should get api identifier and pass it to sms-sender appropriately.

## Supported languages

For now, Java is supported, bash is in the nearest roadmap.
But idea is to support more languages in future.

### Java

To obtain library via build systems add dependency 'yermilov:sms-sender:\<version\>' to your project.
Or you can place .jar file into your classpath. Last way requires 'org.springframework:spring-web:3.2.3.RELEASE', 'commons-lang:commons-lang:2.6' and 'log4j:log4j:1.2.17'.

Speaking about code, just:
- create manually or using IoC container instance of yermilov.smssender.smsru.SmsRuSender class and populate it with api key (mandatory) and org.springframework.web.client.RestTemplate (not mandatory), for example:

    \<bean id="smsSender" class="yermilov.smssender.smsru.SmsRuSender"> <br/>
        \<property name="restTemplate" ref="restTemplate" /> <br/>
        \<property name="apiId" value="y0ur-ap1-1d" /> <br/>
    \</bean>

- and use it just in one line:

    smsSender.sendMessage(SmsMessage.Builder.newSms().to("1234567890").withMessage("Hello, World!").build());
    
## Versioning

### v1.0.0

This is first version available for use.
Support simply sending SMS messages using Java.

