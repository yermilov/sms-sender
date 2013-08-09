sms-sender
==========

Library to organize programming sending SMS messages.

## Implementations

For now, the only supported implementation is [sms.ru](http://sms.ru/) service.

### sms.ru

For more information visit [service homepage](http://sms.ru/).
The main idea is that to use it, one should get api identifier and pass it to sms-sender appropriately.

## Supported languages

For now, Java and bash is supported, but idea is to support more languages in future.

### Java

To obtain library via build systems add dependency 'yermilov:sms-sender:\<version\>' to your project.
Or you can place .jar file into your classpath. Last way requires 'org.springframework:spring-web:3.2.3.RELEASE', 'commons-lang:commons-lang:2.6' and 'log4j:log4j:1.2.17'.

Speaking about code, just:
- create manually or using IoC container instance of yermilov.smssender.smsru.SmsRuSender class and populate it with api key (mandatory) and org.springframework.web.client.RestTemplate (not mandatory), for example:
    
<pre>
<code>
    &lt;bean id="smsSender" class="yermilov.smssender.smsru.SmsRuSender"&gt;
        &lt;property name="restTemplate" ref="restTemplate" /&gt;
        &lt;property name="apiId" value="y0ur-ap1-1d" /&gt;
    &lt;/bean&gt;
</code>
</pre>
    
- and use it just in one line:

<pre>
<code>
    smsSender.sendMessage(SmsMessage.Builder.newSms().to("1234567890").withMessage("Hello, World!").build());
</code>
</pre>

### Bash

Script invokation has following syntax:

    smsend -c <CONFIG_FILE> -k <API_KEY> -p <PHONE_NUMBER> -t <TEXT>

CONFIG_FILE is path to config file (not mandatory) with following syntax:
    
    KEY=<API_KEY> # not mandatory
    PHONE=<PHONE_NUMBER> # not mandatory
    TEXT=<TEXT> # not mandatory
    
Parameters passed via options takes precedence over config file parameters

Example:
    
    >cat config
    KEY="y0ur-ap1-1d"
    >smsend -c config -p "1234567890" -t "Hello, World!"
    
## Versioning

### v1.0.0

This is first version available for use.
Support simply sending SMS messages using Java and bash.

