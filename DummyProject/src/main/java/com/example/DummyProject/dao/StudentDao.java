package com.example.DummyProject.dao;

import com.example.DummyProject.model.Student;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao{
    private final MongoTemplate mongoTemplate;

    public Student create(Student student){
        return mongoTemplate.save(student);
    }

    public List<Student> getStudent() {
        return mongoTemplate.findAll(Student.class);
    }

    public Student getStudentByRollNumber(int rollNumber) {
        Query query = new Query(Criteria.where("rollNumber").is(rollNumber));
        return mongoTemplate.findOne(query,Student.class);
    }

    public Student updateStudent(int rollNumber, Student student) {
        Update update = new Update().set("studentName",student.getStudentName()).set("studentStandard",student.getStudentStandard()).set("studentAddress",student.getStudentAddress());
        Query query = new Query(Criteria.where("rollNumber").is(rollNumber));
        return mongoTemplate.findAndModify(query, update, Student.class);
    }

    public DeleteResult deleteStudent(int rollNumber) {
        Query query=new Query(Criteria.where("rollNumber").is(rollNumber));
        return mongoTemplate.remove(query, Student.class);

    }
}
