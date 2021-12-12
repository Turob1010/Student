package com.Asus.Student.Controller;

import com.Asus.Student.Entity.Student;
import com.Asus.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResource {

    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public Student save(@RequestBody Student student){
        return studentService.create(student);
    }
    @GetMapping("/{studentId}")
    public Student getById(@PathVariable String studentId){
        return studentService.getById(studentId);
    }
    @GetMapping("getall")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @PutMapping("/update")
    public Student update(@RequestBody Student student,@PathVariable String studentId){
        return studentService.update(student,studentId);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Student student,@PathVariable String studentId){
        studentService.delete(student,studentId);
        return ResponseEntity.ok("student delete successfully");
    }
}
