package com.sds.integration.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testError_WithCodeMessageDescriptionAndReference_UpdatesFieldsCorrectly() {
        // Arrange: Create a subclass of AbstractBaseApiResponse for testing
        AbstractBaseApiResponse<String> apiResponse = new AbstractBaseApiResponse<>(true, "200", "Operation Successful",
                null, null, null, null) {
            @Override
            protected AbstractBaseApiResponse<String> success(String code, String message, String data) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description, String errorReference) {
                super.error(code, message, description, errorReference);
                return this;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description) {
                return super.error(code, message, description);
            }
        };

        // Act: Call error with all parameters
        apiResponse.error("400", "Bad Request", "Invalid input provided", "ERR123");

        // Assert: Verify fields are updated correctly
        assertFalse(apiResponse.isSuccess(), "Expected success to be false after calling error.");
        assertEquals("400", apiResponse.getResponseCode(), "Expected response code to match the error code.");
        assertEquals("Bad Request", apiResponse.getResponseMessage(), "Expected response message to match the error message.");
        assertEquals("Invalid input provided", apiResponse.getResponseDescription(), "Expected response description to match the error description.");
        assertEquals("ERR123", apiResponse.getErrorReference(), "Expected error reference to match the provided reference.");
    }

    @Test
    void testError_WithCodeMessageAndDescription_UpdatesFieldsCorrectly() {
        // Arrange: Create a subclass of AbstractBaseApiResponse for testing
        AbstractBaseApiResponse<String> apiResponse = new AbstractBaseApiResponse<>(false, "200", "Operation Successful",
                null, null, null, null) {
            @Override
            protected AbstractBaseApiResponse<String> success(String code, String message, String data) {
                return null;
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description, String errorReference) {
                return super.error(code, message, description, errorReference);
            }

            @Override
            public AbstractBaseApiResponse<String> error(String code, String message, String description) {
                return super.error(code, message, description);
            }
        };

        // Act: Call error with code, message, and description
        apiResponse.error("401", "Unauthorized", "Missing credentials");

        // Assert: Verify fields are updated correctly
        assertFalse(apiResponse.isSuccess(), "Expected success to be false after calling error.");
        assertEquals("401", apiResponse.getResponseCode(), "Expected response code to match the error code.");
        assertEquals("Unauthorized", apiResponse.getResponseMessage(), "Expected response message to match the error message.");
        assertEquals("Missing credentials", apiResponse.getResponseDescription(), "Expected response description to match the error description.");
        assertNull(apiResponse.getErrorReference(), "Expected error reference to be null when not provided.");
    }
}