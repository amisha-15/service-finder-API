package com.example.servicefinder.service;

import com.example.servicefinder.model.ServiceProvider;
import com.example.servicefinder.repository.ServiceProviderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// pagination imports
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository repository;

    //  ADD
    public ServiceProvider add(ServiceProvider sp) {
        return repository.save(sp);
    }

    //  GET ALL (normal)
    public List<ServiceProvider> getAll() {
        return repository.findAll();
    }

    //  GET ALL (pagination)
    public Page<ServiceProvider> getAll(Pageable pageable) {
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
        ServiceProvider existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(sp.getName());
            existing.setService(sp.getService());
            existing.setCity(sp.getCity());
            existing.setContact(sp.getContact());

            return repository.save(existing);
        }

        return null;
    }

    //  DELETE
    public void delete(int id) {
        repository.deleteById(id);
    }
}
