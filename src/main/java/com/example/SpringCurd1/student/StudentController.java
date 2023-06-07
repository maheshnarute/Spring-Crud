package com.example.SpringCurd1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
   private StudentService studentService;
    @GetMapping("/map")
    public List<Student>getcontroller( ){
        return this.studentService.getList();
    }
    @PostMapping("/student")
    public Student student1(@RequestBody Student std){
        return this.studentService.student(std) ;
    }
    @DeleteMapping("student/{id}")
    public void infodelete(@PathVariable ("id")int id){
       this.studentService.deleteinfo(id);
    }
    @PutMapping("student/{id}")
    public void putinfo(@RequestBody Student student, @PathVariable("id") int id){
        this.studentService.infoput(student ,id);
    }


}
