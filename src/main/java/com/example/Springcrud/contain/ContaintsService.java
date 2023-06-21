package com.example.Springcrud.contain;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContaintsService {
    ResponseEntity<?>savecontains(Containts request);
    ResponseEntity<List<Containts>>getAllContains();
    ResponseEntity<Optional<Containts>>getById(UUID Id);
    ResponseEntity<Optional<Containts>>updateContaintsById(UUID Id);
    ResponseEntity<?> deleteContaints(Containts containts);
    ResponseEntity<List<Containts>> getByContact(String contact);
}
