package com.crud.mongodb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.mongodb.Entity.Student;
import com.crud.mongodb.Respositary.Student_Repo;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private Student_Repo student_repo;

    @Override
    public Student saveStudent(Student student) {
       return student_repo.save(student);
    }

    @Override
    public List<Student> GetAllStudent(Student student) {
        return student_repo.findAll();
    }

    @Override
    public Student GetStudentById(String id) {
        Optional<Student> findById=student_repo.findById(id);
        if(findById.isPresent()){
            return findById.get();
        }else{
            throw new RuntimeException("Id is not Present "+ id);
        }
    }

    @Override
    public void DeleteStudent(String id) {
        student_repo.deleteById(id);
    }

    @Override
    public Student UpdateStudent(String id, Student student) {
        Student updateStudent = student_repo.findById(id).get();
        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setCity(student.getCity());
        return student_repo.save(updateStudent);
    }
    
}
