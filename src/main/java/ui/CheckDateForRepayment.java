package ui;

import entity.Student;
import entity.enums.GradeEnum;

import java.time.Year;

public class CheckDateForRepayment {
    public static boolean checkRepayment(Student student) {
        int lastYearsNumber = Year.now().getValue() - student.getEnteringYear().getValue();
        GradeEnum gradeEnum = student.getGradeEnum();
        if (gradeEnum.equals(GradeEnum.DISCONTINUOUS_BACHELOR) ||
                gradeEnum.equals(GradeEnum.CONTINUOUS_BACHELOR)) {
            return lastYearsNumber >= 4;

        }
        if (gradeEnum.equals(GradeEnum.ASSOCIATE) ||
                gradeEnum.equals(GradeEnum.DISCONTINUOUS_MASTER)) {
            return lastYearsNumber >= 2;
        }
        if (gradeEnum.equals(GradeEnum.CONTINUOUS_MASTER)) {
            return lastYearsNumber >= 6;
        }
        if (gradeEnum.equals(GradeEnum.CONTINUOUS_DOCTOR) ||
                gradeEnum.equals(GradeEnum.PROFESSIONAL_DOCTOR) ||
                gradeEnum.equals(GradeEnum.DISCONTINUOUS_PROFESSIONAL_DOCTOR)) {
            return lastYearsNumber >= 5;
        }
        return false;
    }
}
