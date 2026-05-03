package com.sds.integration.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractBaseApiResponseTest {

    /**
     * Test class for AbstractBaseApiResponse.isSuccess method.
     * The isSuccess method is expected to return the current value of the success field.
     */

    @Test
    void testIsSuccess_ReturnsTrue_WhenSuccessIsTrue() {
        // Arrange: Create a subclass of AbstractBaseApiResponse for testing
        AbstractBaseApiResponse<String> apiResponse = new AbstractBaseApiResponse<>(true, "200", "Operation Successful",
                null, null, null, null) {
            @Override
            protected AbstractBaseApiResponse<String> success(String code, String message, String data) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description, String errorReference) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description) {
                return null;
            }
        };

        // Act: Check if success is true
        boolean result = apiResponse.isSuccess();

        // Assert
        assertTrue(result, "Expected isSuccess to return true when success is true.");
    }

    @Test
    void testIsSuccess_ReturnsFalse_WhenSuccessIsFalse() {
        // Arrange: Create a subclass of AbstractBaseApiResponse for testing
        AbstractBaseApiResponse<String> apiResponse = new AbstractBaseApiResponse<>(false, "500", "Operation Failed",
                null, null, null, null) {
            @Override
            protected AbstractBaseApiResponse<String> success(String code, String message, String data) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description, String errorReference) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description) {
                return null;
            }
        };

        // Act: Check if success is false
        boolean result = apiResponse.isSuccess();

        // Assert
        assertFalse(result, "Expected isSuccess to return false when success is false.");
    }

    @Test
    void testIsSuccess_UpdatesToTrue_AfterSetSuccessIsCalled() {
        // Arrange: Create a subclass of AbstractBaseApiResponse for testing
        AbstractBaseApiResponse<String> apiResponse = new AbstractBaseApiResponse<>(false, "500", "Operation Failed",
                null, null, null, null) {
            @Override
            protected AbstractBaseApiResponse<String> success(String code, String message, String data) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description, String errorReference) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description) {
                return null;
            }
        };

        // Act: Update success to true
        apiResponse.setSuccess(true);
        boolean result = apiResponse.isSuccess();

        // Assert
        assertTrue(result, "Expected isSuccess to return true after setSuccess is called with true.");
    }

    @Test
    void testIsSuccess_UpdatesToFalse_AfterSetSuccessIsCalled() {
        // Arrange: Create a subclass of AbstractBaseApiResponse for testing
        AbstractBaseApiResponse<String> apiResponse = new AbstractBaseApiResponse<>(true, "200", "Operation Successful",
                null, null, null, null) {
            @Override
            protected AbstractBaseApiResponse<String> success(String code, String message, String data) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description, String errorReference) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description) {
                return null;
            }
        };

        // Act: Update success to false
        apiResponse.setSuccess(false);
        boolean result = apiResponse.isSuccess();

        // Assert
        assertFalse(result, "Expected isSuccess to return false after setSuccess is called with false.");
    }
}