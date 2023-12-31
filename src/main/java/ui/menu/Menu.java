package ui.menu;

import java.util.Random;

import entity.BankCart;
import entity.Student;
import entity.University;
import entity.enums.GradeEnum;
import exception.UserNotFoundException;
import ui.Printer;
import util.ApplicationContext;
import util.Constant;
import util.SecurityContext;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        while (true) {
            Printer.printItem(Constant.startupItem, "please logIn.... ^_^ ");
            String chosenItem = new Scanner(System.in).next();
            switch (chosenItem) {
                case "1" -> loginMenu();
                case "2" -> signUpMenu();
                case "3" -> System.exit(0);
                default -> Printer.printMessage("Wrong input");
            }
        }
    }

    private static void signUpMenu() {
        Student student = new Student();
        Printer.printMessage("please enter your name :");
        student.setName(scanner.next());
        Printer.printMessage("please enter your last name :");
        student.setLastName(scanner.next());
        Printer.printMessage("please enter your father name :");
        student.setFatherName(scanner.next());
        Printer.printMessage("please enter your mother name :");
        student.setMotherName(scanner.next());
        Printer.printMessage("please enter your national code :");
        String username = scanner.next();
        student.setNationalCode(username);
        student.setBirthdate(getDateFromUser());
        Printer.printMessage("please enter your Student number :");
        student.setStudentNumber(scanner.next());
        Printer.printMessage("please enter your entering year :");
        student.setEnteringYear(getYear());
        Printer.printMessage("please choose your grade  :");
        student.setGradeEnum(gradeEnum());
        Printer.printMessage("please choose your university  :");
        student.setUniversity(chooseUniversity());
        student.setBankCart(saveBankCart());
        String generatePassword = generatePassword();
        student.setPassword(generatePassword);

        ApplicationContext.getStudentService().signUp(student);
        System.out.println("Your username :" + username);
        System.out.println("Your password :" + generatePassword);
        System.out.println("pleas Login...... ^_^ ");
    }

    public static BankCart saveBankCart() {
        BankCart bankCart=new BankCart();
        System.out.println("please Enter the bank account number :");
        bankCart.setCartNumber(scanner.next());
        System.out.println("please enter the bank account EX year  :");
        bankCart.setYear(Year.of(scanner.nextInt()));
        System.out.println("please enter the bank account EX day  :");
        bankCart.setDay(scanner.nextInt());
        System.out.println("please enter the bank account cvv2  :");
        bankCart.setCvv2(scanner.nextInt());
        return bankCart;
    }

    private static String generatePassword() {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()";

        String allCharacters = uppercaseLetters + lowercaseLetters + numbers + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }

    private static University chooseUniversity() {
        List<University> universities = ApplicationContext.getUniversityService().findAll().stream().toList();
        Printer.printItemList(universities, "choose one :");
        while (true) {
            try {
                int i = scanner.nextInt();
                return universities.get(i - 1);
            } catch (InputMismatchException e) {
                System.out.println("your input ");
            }
        }
    }

    private static void loginMenu() {
        Printer.printMessage("please enter username :");
        String username = scanner.next();
        Printer.printMessage("please enter password :");
        String password = scanner.next();
        Student student = null;
        try {
            student = ApplicationContext.getStudentService().logIn(username, password);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        SecurityContext.username=student.getNationalCode();
        SecurityContext.id=student.getId();
        SecurityContext.name=student.getName();
        LoanMenu loanMenu= new LoanMenu();
        loanMenu.loanMenu();
    }

    private static Year getYear() {
        while (true) {
            try {
                return Year.of(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for the year!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static LocalDate getDateFromUser() {
        LocalDate date = LocalDate.of(1, 1, 1);
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter birthdate (yyyy-MM-dd): ");
            String input = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid date.");
            }
        }
        return date;
    }

    private static GradeEnum gradeEnum() {
        while (true) {
            Printer.printItem(Constant.GradeEnum, "Choose one... ");
            String chosenItem = scanner.next();
            switch (chosenItem) {
                case "1" -> {
                    return GradeEnum.ASSOCIATE;
                }
                case "2" -> {
                    return GradeEnum.DISCONTINUOUS_BACHELOR;
                }
                case "3" -> {
                    return GradeEnum.CONTINUOUS_BACHELOR;
                }
                case "4" -> {
                    return GradeEnum.DISCONTINUOUS_MASTER;
                }
                case "5" -> {
                    return GradeEnum.CONTINUOUS_MASTER;
                }
                case "6" -> {
                    return GradeEnum.DISCONTINUOUS_PROFESSIONAL_DOCTOR;
                }
                case "7" -> {
                    return GradeEnum.CONTINUOUS_DOCTOR;
                }
                case "8" -> {
                    return GradeEnum.PROFESSIONAL_DOCTOR;
                }
                default -> Printer.printMessage("Wrong input");
            }
        }

    }

}
