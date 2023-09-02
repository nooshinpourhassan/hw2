package entity;

import entity.enums.GradeEnum;
import entity.enums.UniversityEnum;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        University university =University.builder()
                .name("markazi")
                .universityEnum(UniversityEnum.AZAD_UNIVERSITY)
                .build();
        Student student= Student.builder()
                .name("maryam")
                .gradeEnum(GradeEnum.MASTER)
                .university(university)
                .birthdate(LocalDate.of(1998,2,5))
                .build();

        System.out.println(student);
    }
}
