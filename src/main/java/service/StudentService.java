package service;

import base.service.BaseService;
import entity.Student;

import java.util.Optional;

public interface StudentService extends BaseService<Student,Long> {
    Student logIn(String username, String password);

    boolean  isUserExistsByUsername(String username);

    Optional<Student> getUserByUsername(String username);
}
