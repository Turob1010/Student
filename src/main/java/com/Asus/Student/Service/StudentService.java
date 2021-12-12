package com.Asus.Student.Service;

import com.Asus.Student.Entity.Student;
import com.Asus.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student){
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }
    public Student getById(String studentId){
      Student student = studentRepository.findById(studentId).get();
      return student;
    }
    public List<Student> getAll(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public  Student update(Student student,String studentId){
        studentRepository.findById(studentId);
        Student updateStudent = studentRepository.save(student);
        return updateStudent;
    }
    public void delete(Student student,String studentId){
        studentRepository.findById(studentId);
        studentRepository.delete(student);
    }


}

