package feign;


import exception.SdsCommunicationException;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * @author Joseph.Kibe. Created On 11 Apr 2026 01:25
 */
public class FeignClientFactory {

    private FeignClientFactory() {
    }

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FeignClientFactory.class);

    public static <T> T createConfiguredClient(Class<T> clientClass, String baseUrl,
                                               RequestInterceptor requestInterceptor,
                                               Logger.Level logLevel) {

        if (baseUrl == null) {
            throw new SdsCommunicationException("Base URL cannot be null");
        }

        if (logLevel == null) {
            logLevel = Logger.Level.BASIC;
        }

        if (clientClass == null) {
            throw new SdsCommunicationException("Client class cannot be null");
        }

        if (logLevel.equals(Logger.Level.FULL)) {
            log.info("Full logging is not recommended in production.");
        }

        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger())
                .logLevel(logLevel)
                .options(new Request.Options(Duration.ofMillis(5000L), Duration.ofMillis(10000), false)) // connect timeout, read timeout
                .retryer(new DefaultRetryer(100, 3000, 3))
                .requestInterceptor(requestInterceptor)
                .target(clientClass, baseUrl);
    }
}
