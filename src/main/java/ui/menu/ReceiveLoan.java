package ui.menu;

import entity.Loan;
import entity.Student;
import entity.enums.GradeEnum;
import entity.enums.LoanEnum;
import entity.enums.UniversityEnum;
import ui.Date;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class ReceiveLoan {
    static Date date = new Date();

    public static void tuitionLoan() {
        Student student = ApplicationContext.getStudentService().findById(SecurityContext.id).get();
        if (!date.checkDate())
            System.out.println("Sorry, the loan registration window is currently closed.");
        else {
            UniversityEnum universityEnum = student.getUniversity().getUniversityEnum();
            if (universityEnum.equals(UniversityEnum.DOLATI_ROZANEH_UNIVERSITY) || universityEnum.equals(UniversityEnum.DOLATI_SHABANEH_UNIVERSITY))
                System.out.println("Sorry, It is given to tuition paying students ");
            else {
                Optional<Loan> tuitionLoan = ApplicationContext.getLoanService().getLoanById(student.getId(), LoanEnum.TUITION_LOAN);
                List<Loan> loanList = tuitionLoan.stream()
                        .filter(list -> list.getLoanDate().getMonth() == LocalDate.now().getMonth())
                        .toList();
                if (!loanList.isEmpty())
                    System.out.println("You applied for this month");
                else {
                    if (student.getGradeEnum().equals(GradeEnum.ASSOCIATE) ||
                            student.getGradeEnum().equals(GradeEnum.CONTINUOUS_BACHELOR) ||
                            student.getGradeEnum().equals(GradeEnum.DISCONTINUOUS_BACHELOR)) {
                        Loan loan = Loan.builder()
                                .debtBalance(1300000).
                                loanDate(LocalDate.now())
                                .loanEnum(LoanEnum.TUITION_LOAN)
                                .student(student)
                                .build();
                        try {
                            ApplicationContext.getLoanService().saveOrUpdate(loan);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("successfully");
                    }
                    if (student.getGradeEnum().equals(GradeEnum.DISCONTINUOUS_MASTER) ||
                            student.getGradeEnum().equals(GradeEnum.CONTINUOUS_MASTER) ||
                            student.getGradeEnum().equals(GradeEnum.CONTINUOUS_DOCTOR) ||
                            student.getGradeEnum().equals(GradeEnum.PROFESSIONAL_DOCTOR)) {
                        Loan loan = Loan.builder()
                                .debtBalance(2600000).
                                loanDate(LocalDate.now())
                                .loanEnum(LoanEnum.TUITION_LOAN)
                                .student(student)
                                .build();
                        try {
                            ApplicationContext.getLoanService().saveOrUpdate(loan);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("successfully");
                    } else {
                        Loan loan = Loan.builder()
                                .debtBalance(6500000).
                                loanDate(LocalDate.now())
                                .loanEnum(LoanEnum.TUITION_LOAN)
                                .student(student)
                                .build();
                        try {
                            ApplicationContext.getLoanService().saveOrUpdate(loan);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("successfully");
                    }
                }
            }
        }
    }

    public static void educationLoan() {
        Student student = ApplicationContext.getStudentService().findById(SecurityContext.id).get();
        if (!date.checkDate())
            System.out.println("Sorry, the loan registration window is currently closed.");
        else {
            Optional<Loan> loanOptional = ApplicationContext.getLoanService().getLoanById(student.getId(), LoanEnum.EDUCATION_LOAN);
            List<Loan> loanList = loanOptional.stream()
                    .filter(list -> list.getLoanDate().getMonth() == LocalDate.now().getMonth())
                    .toList();
            if (!loanList.isEmpty())
                System.out.println("You applied for this month");
            else {
                if (student.getGradeEnum().equals(GradeEnum.ASSOCIATE) ||
                        student.getGradeEnum().equals(GradeEnum.CONTINUOUS_BACHELOR) ||
                        student.getGradeEnum().equals(GradeEnum.DISCONTINUOUS_BACHELOR)) {
                    Loan loan = Loan.builder()
                            .debtBalance(190000).
                            loanDate(LocalDate.now())
                            .loanEnum(LoanEnum.EDUCATION_LOAN)
                            .student(student)
                            .build();
                    try {
                        ApplicationContext.getLoanService().saveOrUpdate(loan);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("successfully");
                }
                if (student.getGradeEnum().equals(GradeEnum.DISCONTINUOUS_MASTER) ||
                        student.getGradeEnum().equals(GradeEnum.CONTINUOUS_MASTER) ||
                        student.getGradeEnum().equals(GradeEnum.CONTINUOUS_DOCTOR) ||
                        student.getGradeEnum().equals(GradeEnum.PROFESSIONAL_DOCTOR)) {
                    Loan loan = Loan.builder()
                            .debtBalance(2250000).
                            loanDate(LocalDate.now())
                            .loanEnum(LoanEnum.EDUCATION_LOAN)
                            .student(student)
                            .build();
                    try {
                        ApplicationContext.getLoanService().saveOrUpdate(loan);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("successfully");
                } else {
                    Loan loan = Loan.builder()
                            .debtBalance(2600000).
                            loanDate(LocalDate.now())
                            .loanEnum(LoanEnum.EDUCATION_LOAN)
                            .student(student)
                            .build();
                    try {
                        ApplicationContext.getLoanService().saveOrUpdate(loan);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("successfully");
                }
            }
        }
    }

    public static void housingLoan() {
    }

}
