package ui.menu;

import entity.Loan;
import entity.Student;
import entity.enums.LoanEnum;
import entity.enums.UniversityEnum;
import ui.Date;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

public class ReceiveLoan {
    static Date date =new Date();
    public static void tuitionLoan() {
        Student student= ApplicationContext.getStudentService().findById(SecurityContext.id).get();
        if (!date.checkDate())
            System.out.println("Sorry, the loan registration window is currently closed.");
        else {
            UniversityEnum universityEnum = student.getUniversity().getUniversityEnum();
            if (universityEnum.equals(UniversityEnum.DOLATI_ROZANEH_UNIVERSITY) || universityEnum.equals(UniversityEnum.DOLATI_SHABANEH_UNIVERSITY))
                System.out.println("Sorry, It is given to tuition paying students ");
            else{
                Optional<Loan> tuitionLoan = ApplicationContext.getLoanService().getLoanById(student.getId(), "TUITION_LOAN");
                List<Loan> loanList = tuitionLoan.stream()
                        .filter(list -> list.getLoanDate().getMonth() == LocalDate.now().getMonth())
                        .toList();
                if (!loanList.isEmpty())
                    System.out.println("You applied for this month");
                else {
                    *************************************
                }

            }
        }



    }

    public static void educationLoan() {
    }

    public static void housingLoan() {
    }

    private UniversityEnum getUniversityEnum(){

    }

}
