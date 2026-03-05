package com.example.studentdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.studentdemo.exception.InvalidInputException;
import com.example.studentdemo.model.Student;
import com.example.studentdemo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET Student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } 
        catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        return service.getStudentById(studentId);
    }

    // POST Add Student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        if (student.getId() <= 0) {
            throw new InvalidInputException("Student ID must be greater than 0");
        }

        return service.addStudent(student);
    }
}