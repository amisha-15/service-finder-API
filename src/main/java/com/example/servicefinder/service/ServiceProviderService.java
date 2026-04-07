package com.example.servicefinder.service;

import com.example.servicefinder.model.ServiceProvider;
import com.example.servicefinder.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository repo;

    //ADD
    public ServiceProvider add(ServiceProvider sp){
        return repo.save(sp);
    }
    //GET ALL
    public List<ServiceProvider> getAll(){
        return repo.findAll();
    }
    //SEARCH BY SERVICE
    public List<ServiceProvider> getByService(String service){
        return repo.findByServiceIgnoreCase(service);
    }
    //SEARCH BY CITY
    public List<ServiceProvider> getByCity(String city){
        return repo.findByCityIgnoreCase(city);
    }
    //UPDATE
    public ServiceProvider update(int id, ServiceProvider sp){
        sp.setId(id);
        return repo.save(sp);
    }
    //DELETE
    public void delete(int id){
        repo.deleteById(id);
    }
}
