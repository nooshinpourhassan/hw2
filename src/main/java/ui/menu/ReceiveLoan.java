package ui.menu;

import entity.Information;
import entity.Loan;
import entity.Repayment;
import entity.Student;
import entity.enums.City;
import entity.enums.GradeEnum;
import entity.enums.LoanEnum;
import entity.enums.UniversityEnum;
import ui.Date;
import ui.Printer;
import util.ApplicationContext;
import util.Constant;
import util.SecurityContext;

import java.time.LocalDate;
import java.util.*;

import static ui.menu.Menu.scanner;


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
                                .gradeEnum(student.getGradeEnum())
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
                                .gradeEnum(student.getGradeEnum())
                                .build();
                        try {
                            ApplicationContext.getLoanService().saveOrUpdate(loan);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("successfully");
                    }if((student.getGradeEnum().equals(GradeEnum.DISCONTINUOUS_PROFESSIONAL_DOCTOR))){
                        Loan loan = Loan.builder()
                                .debtBalance(6500000).
                                loanDate(LocalDate.now())
                                .loanEnum(LoanEnum.TUITION_LOAN)
                                .student(student)
                                .gradeEnum(student.getGradeEnum())
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
                            .gradeEnum(student.getGradeEnum())
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
                            .gradeEnum(student.getGradeEnum())
                            .build();
                    try {
                        ApplicationContext.getLoanService().saveOrUpdate(loan);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("successfully");
                } if ((student.getGradeEnum().equals(GradeEnum.DISCONTINUOUS_PROFESSIONAL_DOCTOR))){
                    Loan loan = Loan.builder()
                            .debtBalance(2600000).
                            loanDate(LocalDate.now())
                            .loanEnum(LoanEnum.EDUCATION_LOAN)
                            .student(student)
                            .gradeEnum(student.getGradeEnum())
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
        Student student = ApplicationContext.getStudentService().findById(SecurityContext.id).get();
        Information information = new Information();
        if (!date.checkDate())
            System.out.println("Sorry, the loan registration window is currently closed.");
        else {
            Optional<Loan> optionalLoan = ApplicationContext.getLoanService().getLoanById(student.getId(), LoanEnum.HOUSING_LOAN);
            List<Loan> list1 = optionalLoan.stream()
                    .filter(list -> list.getGradeEnum().equals(student.getGradeEnum())).toList();
            if (!list1.isEmpty())
                System.out.println("You applied for this Grade");
            else {
                System.out.println("please enter your wife or husband national code :");
                String nationalCode = scanner.next();
                Optional<Student> userByUsername = ApplicationContext.getStudentService().getUserByUsername(nationalCode);
                if (!userByUsername.isEmpty()){
                    Student partner = userByUsername.get();
                    Optional<Loan> partnerLoan = ApplicationContext.getLoanService().getLoanById(partner.getId(), LoanEnum.HOUSING_LOAN);
                    List<Loan> list = partnerLoan.stream().filter(loan -> loan.getGradeEnum().equals(partner.getGradeEnum())).toList();
                    if (!list.isEmpty())
                        System.out.println("your wife or husband applied for this Grade ");
                    else {
                     if (ApplicationContext.getInformationService().isInformationExistsByUsername(student.getNationalCode())){
                         Loan loan= Loan.builder()
                                 .student(student)
                                 .loanDate(LocalDate.now())
                                 .loanEnum(LoanEnum.HOUSING_LOAN)
                                 .gradeEnum(student.getGradeEnum())
                                 .debtBalance(student.getInformation().getCity().getLoan()).build();
                         try {
                             ApplicationContext.getLoanService().saveOrUpdate(loan);
                         }catch (Exception e){
                             System.out.println(e.getMessage());
                         }
                     }else {
                         System.out.println("enter your wife or husband national Code : ");
                         information.setPartnerNationalCode(scanner.next());
                         information.setStudent(student);
                         System.out.println("enter your Housing Rental Number :  6-digit");
                         information.setHousingRentalNumber(scanner.next());
                         System.out.println("enter your address : ");
                         information.setAddress(scanner.next());
                         information.setCity(getCity());
                         try {
                             ApplicationContext.getInformationService().saveOrUpdate(information);
                             Loan loan= Loan.builder()
                                     .student(student)
                                     .loanDate(LocalDate.now())
                                     .loanEnum(LoanEnum.HOUSING_LOAN)
                                     .gradeEnum(student.getGradeEnum())
                                     .debtBalance(student.getInformation().getCity().getLoan()).build();
                             ApplicationContext.getLoanService().saveOrUpdate(loan);
                         }catch (Exception e){
                             System.out.println(e.getMessage());
                         }
                     }
                    }
                }else {
                    if (ApplicationContext.getInformationService().isInformationExistsByUsername(student.getNationalCode())){
                        Loan loan= Loan.builder()
                                .student(student)
                                .loanDate(LocalDate.now())
                                .loanEnum(LoanEnum.HOUSING_LOAN)
                                .gradeEnum(student.getGradeEnum())
                                .debtBalance(student.getInformation().getCity().getLoan()).build();
                        try {
                            ApplicationContext.getLoanService().saveOrUpdate(loan);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }else {
                        System.out.println("enter your wife or husband national Code : ");
                        information.setPartnerNationalCode(scanner.next());
                        information.setStudent(student);
                        System.out.println("enter your Housing Rental Number :  6-digit");
                        String HousingRentalNumber = scanner.next();
                        information.setHousingRentalNumber(HousingRentalNumber);
                        System.out.println("enter your address : ");
                        information.setAddress(scanner.next());
                        information.setCity(getCity());
                        try {
                            ApplicationContext.getInformationService().saveOrUpdate(information);
                            Loan loan= Loan.builder()
                                    .student(student)
                                    .loanDate(LocalDate.now())
                                    .loanEnum(LoanEnum.HOUSING_LOAN)
                                    .gradeEnum(student.getGradeEnum())
                                    .debtBalance(student.getInformation().getCity().getLoan()).build();
                            ApplicationContext.getLoanService().saveOrUpdate(loan);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            }
        }
    private static City getCity() {
        while (true) {
            Printer.printItem(Constant.cityMenu , "choose one :");
            String chosenItem = scanner.next();
            switch (chosenItem) {
                case "1" -> {
                    return City.TEHRAN;
                }
                case "2" -> {
                    return City.METROPOLISES;
                }
                case "3" -> {
                    return City.OTHER_CITY;
                }
                default -> Printer.printMessage("Wrong input");
            }
        }
    }
    public static List<Double>  dividePrice(double price) {
        double interest  = price * 0.04;
        price= price+interest;
        List<Double> dividedPrices = new ArrayList<>();
        double partPrice = price / (Math.pow(2, 5) - 1);
        double payments = partPrice / 12;
        for (int j = 0 ; j< 5 ; j++) {
            for (int i = 0; i < 12; i++) {
                dividedPrices.add( Math.round(payments * 10) / 10.0);
            }
            payments *= 2;
        }
        return dividedPrices;
    }

    public static Collection<Repayment> saveRepayment(Loan loan){
        List<Double> price = dividePrice(loan.getDebtBalance());
        int number=1;
        for (Double paid:  price) {
            Repayment repayment = Repayment.builder()
                    .number(number)
                    .build();
        }

    }
}
