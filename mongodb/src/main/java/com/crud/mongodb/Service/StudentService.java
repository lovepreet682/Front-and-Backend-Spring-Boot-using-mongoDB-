package com.crud.mongodb.Service;

import java.util.List;

import com.crud.mongodb.Entity.Student;


public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> GetAllStudent(Student student);
    public Student GetStudentById(String id);
    public void DeleteStudent(String id);
    public Student UpdateStudent(String id, Student student);
}
