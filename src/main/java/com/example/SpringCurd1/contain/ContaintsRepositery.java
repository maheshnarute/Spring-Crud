package com.example.SpringCurd1.contain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface ContaintsRepositery extends JpaRepository<Containts, UUID> {
    List<Containts> findByContact(String contact);

}
