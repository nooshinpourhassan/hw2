package service;

import base.service.BaseService;
import entity.Information;
import entity.Student;

import java.util.Optional;

public interface InformationService extends BaseService<Information,Long> {
    boolean isInformationExistsByUsername(String nationalCode);

    Optional<Information> getInformationByStudentId(Long id);
}
