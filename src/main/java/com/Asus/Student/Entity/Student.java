package com.Asus.Student.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student10")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private  String studentId;
    private String studentName;
    private Integer age;
}
