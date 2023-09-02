package service.impl;

import base.service.BaseServiceImpl;
import entity.Student;
import repository.StudentRepository;
import service.StudentService;

import javax.persistence.EntityManager;
import javax.validation.Validator;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService {


    public StudentServiceImpl(StudentRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
