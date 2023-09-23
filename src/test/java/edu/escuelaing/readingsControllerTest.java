package edu.escuelaing;
import edu.escuelaing.controller.ReadingsController;
import edu.escuelaing.entity.Readings;
import edu.escuelaing.service.ReadingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class readingsControllerTest {
    @InjectMocks
    private ReadingsController readingsController;

    @Mock
    private ReadingsService readingsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllReadings() {

        List<Readings> readingsList = new ArrayList<>();

        when(readingsService.getAllReadings()).thenReturn(readingsList);

        List<Readings> result = readingsController.getAllReadings();
        assertEquals(readingsList, result);
    }


    @Test
    void testGetReadingById() {
        String id = "1";
        when(readingsService.getReadingsById(id)).thenReturn(Optional.of(new Readings()));

        ResponseEntity<Readings> result = readingsController.getReadingById(id);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testGetReadingByIdNotFound() {
        String id = "2";
        when(readingsService.getReadingsById(id)).thenReturn(Optional.empty());

        ResponseEntity<Readings> result = readingsController.getReadingById(id);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    void testCreateReading() {
        Readings reading = new Readings();
        when(readingsService.createReadings(reading)).thenReturn(reading);

        Readings result = readingsController.createReading(reading);
        assertEquals(reading, result);
    }

    @Test
    void testUpdateReading() {
        String id = "1";
        Readings updatedReading = new Readings();
        when(readingsService.updateReadings(eq(id), any(Readings.class))).thenReturn(Optional.of(updatedReading));

        ResponseEntity<Readings> result = readingsController.updateReading(id, updatedReading);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }



}
