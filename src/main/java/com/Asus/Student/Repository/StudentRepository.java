package com.Asus.Student.Repository;

import com.Asus.Student.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends MongoRepository<Student,String> {
}
