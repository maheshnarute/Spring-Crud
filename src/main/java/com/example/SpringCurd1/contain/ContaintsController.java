package com.example.SpringCurd1.contain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/contaits")
public class ContaintsController {
    @Autowired
    ContaintsService containtsService;
    @PostMapping
    ResponseEntity<?>putAllContaints(@RequestBody Containts containts)throws Exception{
        return ResponseEntity.ok(containtsService.savecontains(containts));
    }
    @GetMapping("/all")
    ResponseEntity<?>getAllContaints()throws Exception{
        return ResponseEntity.ok(containtsService.getAllContains());
    }
    @GetMapping("/{Id}")
    ResponseEntity<?>getContaintsById(@PathVariable UUID Id) throws Exception{
        return ResponseEntity.ok(containtsService.getById(Id));
    }
    @PutMapping("/{Id}")
    ResponseEntity<?>updatebyid(@PathVariable UUID Id,@RequestBody Containts update)throws  Exception{
        Containts exitcontaints=containtsService.getById(Id).getBody().orElse(null);
        if (exitcontaints==null){
            return ResponseEntity.notFound().build();
        }else {
            exitcontaints.setContact(update.getContact());
            exitcontaints.setName(update.getName());
            exitcontaints.setProfile(update.getProfile());
            exitcontaints.setFacebookurl(update.getFacebookurl());
        }
        containtsService.savecontains(exitcontaints);
        return ResponseEntity.ok("successfully updated ");

    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteContaintsById(@PathVariable UUID id) throws Exception {
        Containts existingContaints = containtsService.getById(id).getBody().orElse(null);
        if (existingContaints == null) {
            return ResponseEntity.notFound().build();
        }

        containtsService.deleteContaints(existingContaints);

        return ResponseEntity.ok("Deleted successfully");
    }
    @GetMapping("/byc/{contact}")
    ResponseEntity<?> getContaintsByContact(@PathVariable String contact) throws Exception {
        List<Containts> containtsList = containtsService.getByContact(contact).getBody();
        if (containtsList != null && !containtsList.isEmpty()) {
            return ResponseEntity.ok(containtsList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/bycontact/{contact}")
//    ResponseEntity<?> getContaintsByContact(@PathVariable String contact) throws Exception {
//        return ResponseEntity.ok(containtsService.getByContact(contact));
//    }
//    @GetMapping("/byc/{contact}")
//        ResponseEntity<List<Containts>>getbycontact(@PathVariable("contact") String contact)throws Exception{
//        return ResponseEntity.ok((List<Containts>) containtsService.getByContact(contact));
//        }

}
