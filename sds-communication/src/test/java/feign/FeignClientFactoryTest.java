package feign;

import com.sds.communication.feign.FeignClientFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FeignClientFactoryTest {

    interface TestClient {
        @RequestLine("GET /test")
        String getTestResponse();
    }

    @Test
    void testCreateConfiguredClientWithBasicSetup() {
        // Arrange
        String baseUrl = "http://localhost:8080";
        RequestInterceptor requestInterceptor = request -> request.header("Example-Header", "ExampleValue");
        Logger.Level logLevel = Logger.Level.BASIC;

        // Act
        TestClient client = FeignClientFactory.createConfiguredClient(TestClient.class, baseUrl, requestInterceptor, logLevel);

        // Assert
        assertNotNull(client, "The generated client should not be null");
    }

    @Test
    void testCreateConfiguredClientWithDifferentLogLevel() {
        // Arrange
        String baseUrl = "http://localhost:8080";
        RequestInterceptor requestInterceptor = request -> request.header("Authorization", "Bearer token");
        Logger.Level logLevel = Logger.Level.FULL;

        // Act
        TestClient client = FeignClientFactory.createConfiguredClient(TestClient.class, baseUrl, requestInterceptor, logLevel);

        // Assert
        assertNotNull(client, "The generated client should not be null");
    }
}