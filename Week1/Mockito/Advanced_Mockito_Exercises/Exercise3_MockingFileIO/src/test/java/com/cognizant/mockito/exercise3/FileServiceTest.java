package com.cognizant.mockito.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {

        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        when(mockFileReader.read())
                .thenReturn("Mock File Content - Pratyush Kumar Mohanty (23053320)");

        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        String result = fileService.processFile();

        verify(mockFileWriter).write("Mock File Content - Pratyush Kumar Mohanty (23053320)");

        assertEquals(
                "Processed Mock File Content - Pratyush Kumar Mohanty (23053320)",
                result
        );

    }

}