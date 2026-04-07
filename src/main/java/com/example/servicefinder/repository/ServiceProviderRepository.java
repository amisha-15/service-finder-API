package com.example.servicefinder.repository;

import com.example.servicefinder.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

    //custom search methods
    List<ServiceProvider> findByServiceIgnoreCase(String service);

    List<ServiceProvider> findByCityIgnoreCase(String city);
}
