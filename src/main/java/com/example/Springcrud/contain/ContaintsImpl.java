package com.example.Springcrud.contain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ContaintsImpl implements ContaintsService{
    @Autowired
    ContaintsRepositery containtsRepositery;
    Logger logger= LoggerFactory.getLogger(Containts.class);
    @Override
    public ResponseEntity<?> savecontains(Containts request) {
        containtsRepositery.save(request);
        return new ResponseEntity<>("submitted successfully", HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<List<Containts>> getAllContains() {
        logger.info("getting successfully",HttpStatus.OK);
        return ResponseEntity.ok(containtsRepositery.findAll());
    }

    @Override
    public ResponseEntity<Optional<Containts>> getById(UUID Id) {
        logger.info("getting by id",HttpStatus.OK);
        return ResponseEntity.ok(containtsRepositery.findById(Id));
    }

    @Override
    public ResponseEntity<Optional<Containts>> updateContaintsById(UUID Id) {
        logger.info("updated successfully",HttpStatus.OK);
        return ResponseEntity.ok(containtsRepositery.findById(Id));
    }
    @Override
    public ResponseEntity<?> deleteContaints(Containts containts) {
        UUID Id = containts.getId();
        Optional<Containts> existingContaints = containtsRepositery.findById(Id);
        if (existingContaints.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        containtsRepositery.delete(containts);
        return ResponseEntity.ok("Deleted successfully");

    }

    @Override
    public ResponseEntity<List<Containts>> getByContact(String contact) {
        List<Containts> result = containtsRepositery.findByContact(contact);
        return ResponseEntity.ok(result);
    }

}
