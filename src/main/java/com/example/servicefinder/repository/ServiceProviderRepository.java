package com.example.servicefinder.repository;

import com.example.servicefinder.model.ServiceProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

    //custom search methods
    List<ServiceProvider> findByServiceIgnoreCase(String service);

    List<ServiceProvider> findByCityIgnoreCase(String city);

    // pagination method (ADD this)
    Page<ServiceProvider> findAll(Pageable pageable);
}
