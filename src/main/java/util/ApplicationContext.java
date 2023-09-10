package util;

import repository.InformationRepository;
import repository.LoanRepository;
import repository.StudentRepository;
import repository.UniversityRepository;
import repository.impl.InformationRepositoryImpl;
import repository.impl.LoanRepositoryImpl;
import repository.impl.StudentRepositoryImpl;
import repository.impl.UniversityRepositoryImpl;
import service.InformationService;
import service.LoanService;
import service.StudentService;
import service.UniversityService;
import service.impl.InformationServiceImpl;
import service.impl.LoanServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.UniversityServiceImpl;
import validator.EntityValidator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validator;

public class ApplicationContext {
    static final EntityManagerFactory EMF;
    static final EntityManager EM;
    private static final Validator VALIDATOR;


    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;

    private static final LoanRepository LOAN_REPOSITORY;
    private static final LoanService LOAN_SERVICE;

    private static final UniversityRepository UNIVERSITY_REPOSITORY;
    private static final UniversityService UNIVERSITY_SERVICE;

    private static final InformationRepository INFORMATION_REPOSITORY;
    private static final InformationService INFORMATION_SERVICE;

    static {
        EMF = Persistence.createEntityManagerFactory("default");
        EM = EMF.createEntityManager();
        VALIDATOR= EntityValidator.validator;
        STUDENT_REPOSITORY = new StudentRepositoryImpl(EM);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY,VALIDATOR,EM);
        LOAN_REPOSITORY = new LoanRepositoryImpl(EM);
        LOAN_SERVICE = new LoanServiceImpl(LOAN_REPOSITORY,VALIDATOR,EM);
        UNIVERSITY_REPOSITORY = new UniversityRepositoryImpl(EM);
        UNIVERSITY_SERVICE = new UniversityServiceImpl(UNIVERSITY_REPOSITORY,VALIDATOR,EM);
        INFORMATION_REPOSITORY = new InformationRepositoryImpl(EM);
        INFORMATION_SERVICE = new InformationServiceImpl(INFORMATION_REPOSITORY,VALIDATOR,EM);
    }
    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static LoanService getLoanService() {
        return LOAN_SERVICE;
    }

    public static UniversityService getUniversityService() {
        return UNIVERSITY_SERVICE;
    }
    public static InformationService getInformationService() {
        return INFORMATION_SERVICE;
    }
}
