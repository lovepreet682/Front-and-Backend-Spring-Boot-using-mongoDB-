package com.crud.mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.mongodb.Entity.Student;
import com.crud.mongodb.Service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    //Just for Testing
    @GetMapping("/")
    public String Home(){
        return "This is working fine";
    }

    //Post the Data
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student Value Saved";
    }

    //Fetch the Data
    @GetMapping("/student")
    public List<Student> getStudentValues(Student student) {
        List<Student> Value = studentService.GetAllStudent(student);
        return Value;
    }

    //fetch the Data by Id
    @GetMapping("/student/{id}")
    public Student getDataById(@PathVariable String id, Student student){
        Student getValue=studentService.GetStudentById(id);
        return getValue;

    }

    //delete the data
    @DeleteMapping("/student/{id}")
    public String deleteData(@PathVariable String id){
        studentService.DeleteStudent(id);
        return "Id Deleted Successfully";
    }

    //Update the value
    @PutMapping("/student/{id}")
    public Student updateData(@PathVariable String id, @RequestBody Student student){
        student.setId(id);
        studentService.UpdateStudent(id, student);
        return student;
    }

}
