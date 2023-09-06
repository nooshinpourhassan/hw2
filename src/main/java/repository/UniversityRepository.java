package repository;

import base.repository.BaseRepository;
import entity.Student;
import entity.University;

import java.util.List;

public interface UniversityRepository extends BaseRepository<University,Long> {
    List<University> findUniversity(String title);
}
