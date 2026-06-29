package com.cognizant.mockito.exercise5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {

        Repository mockRepository = mock(Repository.class);

        when(mockRepository.getData())
                .thenReturn("First Mock Data - Pratyush Kumar Mohanty (23053320)")
                .thenReturn("Second Mock Data - Pratyush Kumar Mohanty (23053320)");

        Service service = new Service(mockRepository);

        String firstResult = service.processData();
        String secondResult = service.processData();

        verify(mockRepository, times(2)).getData();

        assertEquals(
                "Processed First Mock Data - Pratyush Kumar Mohanty (23053320)",
                firstResult
        );

        assertEquals(
                "Processed Second Mock Data - Pratyush Kumar Mohanty (23053320)",
                secondResult
        );

    }

}