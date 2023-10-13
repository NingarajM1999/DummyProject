package com.example.DummyProject.service;

import com.example.DummyProject.model.ResponseDTO;
import com.example.DummyProject.model.Student;

public interface StudentService {
    ResponseDTO createStudentDetails(Student student);

    ResponseDTO getStudent();

    ResponseDTO getStudentByRollNumber(int rollNumber);

    ResponseDTO updateStudent(int rollNumber, Student student);

    ResponseDTO deleteStudent(int rollNumber);
}
