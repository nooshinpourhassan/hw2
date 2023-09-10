package repository;

import base.repository.BaseRepository;
import entity.Information;
import entity.enums.GradeEnum;

public interface InformationRepository extends BaseRepository<Information,Long> {
    boolean isStudentExistsByUsername(String nationalCode);
}
