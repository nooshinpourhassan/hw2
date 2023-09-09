package repository;

import base.repository.BaseRepository;
import entity.Student;

import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student, Long> {
    boolean isStudentExistsByUsername(String username);
    Optional<Student> getUserByUsername(String username);

}
