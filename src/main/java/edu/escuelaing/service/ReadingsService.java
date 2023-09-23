package edu.escuelaing.service;

import edu.escuelaing.entity.Readings;

import java.util.List;
import java.util.Optional;

public interface ReadingsService {
    List<Readings> getAllReadings();

    Optional<Readings> getReadingsById(String id);

    Readings createReadings(Readings readings);

    Optional<Readings> updateReadings(String id, Readings newReadings);

    void deleteReadings(String id);
}
