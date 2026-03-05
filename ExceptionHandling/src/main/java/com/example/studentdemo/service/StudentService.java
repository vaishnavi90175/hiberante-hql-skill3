package com.example.studentdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.studentdemo.exception.StudentNotFoundException;
import com.example.studentdemo.model.Student;

@Service
public class StudentService {

    private static Map<Integer, Student> studentDB = new HashMap<>();

    static {
        studentDB.put(1, new Student(1,"Rahul","CSE"));
        studentDB.put(2, new Student(2,"Ananya","IT"));
        studentDB.put(3, new Student(3,"Kiran","ECE"));
    }

    public Student getStudentById(int id) {

        if(!studentDB.containsKey(id)){
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return studentDB.get(id);
    }

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}
}