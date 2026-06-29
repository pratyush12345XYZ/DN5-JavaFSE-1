package com.cognizant.mockito.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {

        RestClient mockRestClient = mock(RestClient.class);

        when(mockRestClient.getResponse())
                .thenReturn("Mock Response for Pratyush Kumar Mohanty (23053320)");

        ApiService apiService = new ApiService(mockRestClient);

        String result = apiService.fetchData();

        assertEquals(
                "Fetched Mock Response for Pratyush Kumar Mohanty (23053320)",
                result
        );

    }

}