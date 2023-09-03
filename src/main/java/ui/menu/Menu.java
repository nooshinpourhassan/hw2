package ui.menu;

import entity.Student;
import entity.enums.GradeEnum;
import exception.DateTimeParseException;
import ui.Printer;
import util.ApplicationContext;
import util.Constant;

import java.time.LocalDate;
import java.time.Year;
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
        student.setNationalCode(scanner.next());
        Printer.printMessage("please enter your birthday :");
        student.setBirthdate(getBirthdate());
        Printer.printMessage("please enter your Student number :");
        student.setStudentNumber(scanner.next());
        Printer.printMessage("please enter your entering year :");
        student.setEnteringYear(getYear());
        Printer.printMessage("please choose your grade  :");
        student.setGradeEnum(gradeEnum());
    }

    private static void loginMenu() {
        Printer.printMessage("please enter username :");
        String username = scanner.nextLine();
        Printer.printMessage("please enter password :");
        String password = scanner.nextLine();
        Student student = new Student();
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
    private static LocalDate getBirthdate() {
        System.out.print("Please enter your birthdate (yyyy-mm-dd): ");
        String input = scanner.nextLine();
        LocalDate birthdate = null;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                birthdate = LocalDate.parse(input);
                isValidInput = true;
            } catch (DateTimeParseException e) {
                System.out.print("Invalid input. Please enter your birthdate in the format (yyyy-mm-dd): ");
                input = scanner.nextLine();
            }
        }
        return birthdate;
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
                    return GradeEnum.BACHELOR;
                }
                case "3" -> {
                    return GradeEnum.MASTER;
                }
                case "4" -> {
                    return GradeEnum.DOCTOR;
                }
                default -> Printer.printMessage("Wrong input");
            }
        }

    }
}
