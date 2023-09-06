package service;

import base.service.BaseService;
import entity.University;

import java.util.List;

public interface UniversityService extends BaseService<University,Long> {
    List<University> findUniversity(String title);
}
