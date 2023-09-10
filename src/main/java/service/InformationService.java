package service;

import base.service.BaseService;
import entity.Information;

public interface InformationService extends BaseService<Information,Long> {
    boolean isInformationExistsByUsername(String nationalCode);


}
