package service.impl;

import base.service.BaseServiceImpl;
import entity.Student;
import exception.PasswordInvalidExcepton;
import exception.UserNotFoundException;
import exception.UsernameAlreadyExistsException;
import repository.StudentRepository;
import service.StudentService;

import javax.persistence.EntityManager;
import javax.validation.Validator;
import java.util.Optional;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService {


    public StudentServiceImpl(StudentRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student logIn(String username, String password) {
        if (! isUserExistsByUsername(username))
            throw new UserNotFoundException("user not found...");
        Optional<Student> user = getUserByUsername(username);
        Student student = user.get();
        if (!student.getPassword().equals(password))
            throw new PasswordInvalidExcepton("Password is wrong");
        return student;
    }

    @Override
    public boolean isUserExistsByUsername(String username) {
        return repository.isStudentExistsByUsername(username);
    }

    @Override
    public Optional<Student> getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }

    @Override
    public Student signUp(Student student) {
        if (isUserExistsByUsername(student.getNationalCode()))
            throw new UsernameAlreadyExistsException("username is exists");
        if (!isValid(student))
            return null;
        Student student1 = saveOrUpdate(student);
        System.out.println("Done , please LogIn...");
        return student1;
    }
}
