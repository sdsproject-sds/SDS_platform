package feign;


import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

import java.time.Duration;

/**
 * @author Joseph.Kibe. Created On 11 Apr 2026 01:25
 */
public class FeignClientFactory {

    public static <T> T createConfiguredClient(Class<T> clientClass, String baseUrl,
                                               RequestInterceptor requestInterceptor,
                                               Logger.Level logLevel) {
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
