package edu.escuelaing.service.impl;

import edu.escuelaing.entity.Readings;
import edu.escuelaing.service.ReadingsService;
import edu.escuelaing.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingsServiceImpl implements ReadingsService {
    private final ReadingsRepository readingsRepository;

    @Autowired
    public ReadingsServiceImpl(ReadingsRepository readingsRepository) {
        this.readingsRepository = readingsRepository;
    }

    @Override
    public List<Readings> getAllReadings() {
        return readingsRepository.findAll();
    }

    @Override
    public Optional<Readings> getReadingsById(String id) {
        return readingsRepository.findById(id);
    }

    @Override
    public Readings createReadings(Readings readings) {
        return readingsRepository.save(readings);
    }

    @Override
    public Optional<Readings> updateReadings(String id, Readings newReadings) {
        return readingsRepository.findById(id).map(existingReadings -> {
            // Verificar si los campos en el cuerpo de la solicitud son nulos y, si no lo son, actualizarlos
            if (newReadings.getUsername() != null) {
                existingReadings.setUsername(newReadings.getUsername());
            }
            if (newReadings.getTechAddress() != null) {
                existingReadings.setTechAddress(newReadings.getTechAddress());
            }
            if (newReadings.getPreviousReading() != 0) {
                existingReadings.setPreviousReading(newReadings.getPreviousReading());
            }
            if (newReadings.getCurrentReading() != 0) {
                existingReadings.setCurrentReading(newReadings.getCurrentReading());
            }
            if (newReadings.getConsumption() != 0) {
                existingReadings.setConsumption(newReadings.getConsumption());
            }
            if (newReadings.getCounterNumber() != null) {
                existingReadings.setCounterNumber(newReadings.getCounterNumber());
            }
            if (newReadings.getMonth() != null) {
                existingReadings.setMonth(newReadings.getMonth());
            }
            if (newReadings.getYear() != 0) {
                existingReadings.setYear(newReadings.getYear());
            }

            return readingsRepository.save(existingReadings);
        });
    }


    @Override
    public void deleteReadings(String id) {
        readingsRepository.deleteById(id);
    }

}
