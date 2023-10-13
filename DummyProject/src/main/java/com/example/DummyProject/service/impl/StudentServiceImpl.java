package com.example.DummyProject.service.impl;

import com.example.DummyProject.dao.StudentDao;
import com.example.DummyProject.model.ResponseDTO;
import com.example.DummyProject.model.Student;
import com.example.DummyProject.service.StudentService;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
    @Override
    public ResponseDTO createStudentDetails(Student student) {
        student.setId(UUID.randomUUID().toString());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponseCode(HttpStatus.OK.value());
        responseDTO.setResponseObject(studentDao.create(student));
        responseDTO.setMessage("saved");
        return responseDTO;
    }

    @Override
    public ResponseDTO getStudent() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("fetched");
        responseDTO.setResponseObject(studentDao.getStudent());
        responseDTO.setResponseCode(HttpStatus.OK.value());

        return responseDTO;
    }

    @Override
    public ResponseDTO getStudentByRollNumber(int rollNumber) {
        ResponseDTO responseDTO = new ResponseDTO();
       Student student= studentDao.getStudentByRollNumber(rollNumber);
       if(Objects.nonNull(student)){
           responseDTO.setMessage("fetched successful");
           responseDTO.setResponseCode(HttpStatus.FOUND.value());
           responseDTO.setResponseObject(student);
       }else{
           responseDTO.setMessage("not found");
           responseDTO.setResponseCode(HttpStatus.NOT_FOUND.value());
       }
        return responseDTO;
    }

    @Override
    public ResponseDTO updateStudent(int rollNumber, Student student) {
        ResponseDTO responseDTO = new ResponseDTO();
        Student student1 = studentDao.updateStudent(rollNumber, student);
        if(Objects.nonNull(student1)){
            responseDTO.setMessage("updated");
            responseDTO.setResponseObject(student1);
            responseDTO.setResponseCode(HttpStatus.FOUND.value());
        }else{
            responseDTO.setResponseObject(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("Not found");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteStudent(int rollNumber) {
        ResponseDTO responseDTO = new ResponseDTO();
        DeleteResult student = studentDao.deleteStudent(rollNumber);
        if(Objects.nonNull(student)){
            responseDTO.setMessage("deleted");
            responseDTO.setResponseCode(HttpStatus.FOUND.value());
            responseDTO.setResponseObject(student);
        }else{
            responseDTO.setMessage("roll number student is not present");
            responseDTO.setResponseCode(HttpStatus.NOT_FOUND.value());
        }
        return responseDTO;
    }
}
