package com.crud.mongodb.Respositary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.mongodb.Entity.Student;

@Repository
public interface Student_Repo extends MongoRepository<Student, String>{
    
}
