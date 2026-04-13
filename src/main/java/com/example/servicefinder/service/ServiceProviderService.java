package com.example.servicefinder.service;

import com.example.servicefinder.exception.ResourceNotFoundException;
import com.example.servicefinder.model.ServiceProvider;
import com.example.servicefinder.repository.ServiceProviderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

// pagination imports
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ServiceProviderService {
    private static final Logger logger =
            LoggerFactory.getLogger(ServiceProviderService.class);

    @Autowired
    private ServiceProviderRepository repository;

    //  ADD
    public ServiceProvider add(ServiceProvider sp) {

        logger.info("Saving service provider: {}", sp.getName());

        return repository.save(sp);
    }

    //  GET ALL (normal)
    public List<ServiceProvider> getAll() {

        logger.info("Fetching all service providers");

        return repository.findAll();
    }

    //  GET ALL (pagination)
    public Page<ServiceProvider> getAll(Pageable pageable) {

        logger.info("Fetching service providers with pagination: page={}, size={}",
                pageable.getPageNumber(), pageable.getPageSize());

        return repository.findAll(pageable);
    }

    //  SEARCH BY SERVICE
    public List<ServiceProvider> getByService(String service) {
        return repository.findByServiceIgnoreCase(service);
    }

    //  SEARCH BY CITY
    public List<ServiceProvider> getByCity(String city) {
        return repository.findByCityIgnoreCase(city);
    }

    //  UPDATE
    public ServiceProvider update(int id, ServiceProvider sp) {

        logger.info("Updating service provider with id: {}", id);

        ServiceProvider existing = repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Service provider not found with id: {}", id);
                    return new ResourceNotFoundException("Not found");
                });

        existing.setName(sp.getName());
        existing.setService(sp.getService());
        existing.setCity(sp.getCity());
        existing.setContact(sp.getContact());

        return repository.save(existing);
    }

    //  DELETE
    public void delete(int id) {
        repository.deleteById(id);
    }
}
