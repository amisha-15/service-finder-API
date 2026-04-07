package com.example.servicefinder.controller;

import com.example.servicefinder.model.ServiceProvider;
import com.example.servicefinder.service.ServiceProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService service;

    //ADD
    @PostMapping("/add")
    public ServiceProvider add(@Valid @RequestBody ServiceProvider sp){
        return service.add(sp);
    }
    //GET ALL
    @GetMapping("/all")
    public List<ServiceProvider> getAll(){
        return service.getAll();
    }
    //SEARCH BY SERVICE
    @GetMapping("/search/service")
    public List<ServiceProvider> getByService(@RequestParam String serviceName){
        return service.getByService(serviceName);
    }
    //SEARCH BY CITY
    @GetMapping("/search/city")
    public List<ServiceProvider> getByCity(@RequestParam String city ){
        return service.getByCity(city);
    }
    //UPDATE
    @PutMapping("/update/{id}")
    public ServiceProvider update(@PathVariable int id, @RequestBody ServiceProvider sp){
        return service.update(id,sp);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "Deleted successfully";
    }

}
