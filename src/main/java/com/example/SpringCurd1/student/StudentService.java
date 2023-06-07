package com.example.SpringCurd1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
  private StudentRepo studentRepo;
    public List<Student>list=new ArrayList<>();{
        list.add(new Student(1,"mahesh","mahesh@123","pass"));
        list.add(new Student(2,"swapnil","swapnil@13","swapnil1"));
        list.add(new Student(3,"datta","datta@12","datta12"));

    }
    public List<Student>getList(){
        return list;
    }
    public Student addstudent(Student s){
        list.add(s);
        return s;
    }
    public void deleteinfo(int id){
        Student student;
        list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
      }
      public void infoput(Student student, int id){
        list.stream().map(e->{
            if (e.getId()==id){
                e.setName(student.getName());
                e.setEmail(student.getEmail());
                e.setPassword(student.getPassword());
            }
            return e;
        }).collect(Collectors.toList());

      }

}
