package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender; //0女1男
    private String department;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

//    public Employees(Integer id, String name, String email, Integer gender, Department department) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//        this.department = department;
//        this.birth = new Date();
//    }
}
