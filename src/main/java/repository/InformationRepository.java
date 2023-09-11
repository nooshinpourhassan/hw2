package repository;

import base.repository.BaseRepository;
import entity.Information;
import entity.Student;
import entity.enums.GradeEnum;

import java.util.Optional;

public interface InformationRepository extends BaseRepository<Information,Long> {
    boolean isInformationExistsByUsername(String nationalCode);

    Optional<Information> getInformationByStudentId(Long id);
}
