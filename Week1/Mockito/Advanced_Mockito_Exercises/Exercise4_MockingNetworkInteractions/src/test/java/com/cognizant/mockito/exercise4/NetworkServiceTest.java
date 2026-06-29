package com.cognizant.mockito.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {

        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        when(mockNetworkClient.connect())
                .thenReturn("Mock Connection for Pratyush Kumar Mohanty (23053320)");

        NetworkService networkService = new NetworkService(mockNetworkClient);

        String result = networkService.connectToServer();

        verify(mockNetworkClient).connect();

        assertEquals(
                "Connected to Mock Connection for Pratyush Kumar Mohanty (23053320)",
                result
        );

    }

}