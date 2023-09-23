package edu.escuelaing.controller;
import edu.escuelaing.entity.Readings;
import edu.escuelaing.service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/readings")
public class ReadingsController {
    private final ReadingsService readingsService;

    @Autowired
    public ReadingsController(ReadingsService readingsService) {
        this.readingsService = readingsService;
    }

    @GetMapping
    public List<Readings> getAllReadings() {
        return readingsService.getAllReadings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Readings> getReadingById(@PathVariable String id) {
        Optional<Readings> readings = readingsService.getReadingsById(id);
        return readings.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Readings createReading(@RequestBody Readings readings) {
        return readingsService.createReadings(readings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Readings> updateReading(@PathVariable String id, @RequestBody Readings newReadings) {
        Optional<Readings> updatedReadings = readingsService.updateReadings(id, newReadings);
        return updatedReadings.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReading(@PathVariable String id) {
        readingsService.deleteReadings(id);
        return ResponseEntity.noContent().build();
    }
}
