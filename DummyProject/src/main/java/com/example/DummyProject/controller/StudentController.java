package com.example.DummyProject.controller;

import com.example.DummyProject.model.ResponseDTO;
import com.example.DummyProject.model.Student;
import com.example.DummyProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student")
    public ResponseDTO createStudentDetails(@RequestBody Student student){
        return  studentService.createStudentDetails(student);
    }
    @GetMapping("/getAllStudents")
    public ResponseDTO getStudent(){
        return studentService.getStudent();
    }
    @GetMapping("/getByRollNumber")
    public ResponseDTO getStudentByRollNumber(@RequestParam int rollNumber){
        return studentService.getStudentByRollNumber(rollNumber);
    }
    @PutMapping("/student/{rollNumber}")
    public ResponseDTO updateStudent(@PathVariable int rollNumber,@RequestBody Student student){
        return studentService.updateStudent(rollNumber,student);
    }
    @DeleteMapping("/student")
    public ResponseDTO deleteStudent(@RequestParam int rollNumber){
        return studentService.deleteStudent(rollNumber);
    }
}
