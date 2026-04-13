package com.example.servicefinder.controller;

import com.example.servicefinder.dto.ServiceProviderDTO;
import com.example.servicefinder.dto.ServiceProviderResponseDTO;
import com.example.servicefinder.model.ServiceProvider;
import com.example.servicefinder.service.ServiceProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "Service Provider API", description = "Manage service providers")
@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService service;

    //ADD
    @PostMapping("/add")
    public ResponseEntity<ServiceProviderResponseDTO> add(@Valid @RequestBody ServiceProviderDTO dto) {

        ServiceProvider sp = new ServiceProvider();
        sp.setName(dto.getName());
        sp.setService(dto.getService());
        sp.setCity(dto.getCity());
        sp.setContact(dto.getContact());

        ServiceProvider saved = service.add(sp);

        // convert to response DTO
        ServiceProviderResponseDTO response = new ServiceProviderResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setService(saved.getService());
        response.setCity(saved.getCity());

        return ResponseEntity.status(201).body(response);
    }
    //GET ALL
    @Operation(summary = "Get all service providers")
    @GetMapping("/all")
    public ResponseEntity<List<ServiceProviderResponseDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ServiceProvider> pageData = service.getAll(pageable);

        List<ServiceProviderResponseDTO> result = new ArrayList<>();

        for (ServiceProvider sp : pageData.getContent()) {
            ServiceProviderResponseDTO dto = new ServiceProviderResponseDTO();
            dto.setId(sp.getId());
            dto.setName(sp.getName());
            dto.setService(sp.getService());
            dto.setCity(sp.getCity());
            result.add(dto);
        }

        return ResponseEntity.ok(result);
    }
    //SEARCH BY SERVICE
    @GetMapping("/search/service")
    public List<ServiceProviderResponseDTO> getByService(@RequestParam String serviceName) {

        List<ServiceProvider> list = service.getByService(serviceName);
        List<ServiceProviderResponseDTO> result = new ArrayList<>();

        for (ServiceProvider sp : list) {
            ServiceProviderResponseDTO dto = new ServiceProviderResponseDTO();
            dto.setId(sp.getId());
            dto.setName(sp.getName());
            dto.setService(sp.getService());
            dto.setCity(sp.getCity());
            result.add(dto);
        }

        return result;
    }
    //SEARCH BY CITY
    @GetMapping("/search/city")
    public List<ServiceProviderResponseDTO> getByCity(@RequestParam String city) {

        List<ServiceProvider> list = service.getByCity(city);
        List<ServiceProviderResponseDTO> result = new ArrayList<>();

        for (ServiceProvider sp : list) {
            ServiceProviderResponseDTO dto = new ServiceProviderResponseDTO();
            dto.setId(sp.getId());
            dto.setName(sp.getName());
            dto.setService(sp.getService());
            dto.setCity(sp.getCity());
            result.add(dto);
        }

        return result;
    }
    //UPDATE
    @PutMapping("/update/{id}")
    public ServiceProvider update(@PathVariable int id,
                                  @Valid @RequestBody ServiceProviderDTO dto) {

        ServiceProvider sp = new ServiceProvider();
        sp.setId(id);
        sp.setName(dto.getName());
        sp.setService(dto.getService());
        sp.setCity(dto.getCity());
        sp.setContact(dto.getContact());

        return service.update(id, sp);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "Deleted successfully";
    }

}
