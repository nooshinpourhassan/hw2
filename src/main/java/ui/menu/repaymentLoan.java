package ui.menu;

import entity.BankCart;
import entity.Repayment;
import entity.Student;
import ui.Printer;
import util.ApplicationContext;
import util.SecurityContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import static ui.menu.Menu.scanner;

public class repaymentLoan {
    public static void installmentsPaid() {
        System.out.println(ApplicationContext.getRepaymentService().findPaidInstalment(SecurityContext.username));
    }

    public static void unpaidInstallments() {
        System.out.println(ApplicationContext.getRepaymentService().findUnpaidInstalment(SecurityContext.username));
    }

    public static void installmentPayment() {
        Student student = ApplicationContext.getStudentService().getUserByUsername(SecurityContext.username).get();
        Optional<Repayment> repaymentList = ApplicationContext.getRepaymentService().findInstalment(SecurityContext.username, LocalDate.now().getMonth());
        if (repaymentList.isEmpty())
            System.out.println("You do not have an installment this month");
        else {
            Printer.printItemList(repaymentList.stream().toList(),"choose one");
            int number = 0;
            boolean flag = true;
            while (flag) {
                try {
                    number = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
                BankCart bankCart = Menu.saveBankCart();
                if (!bankCart.equals(student.getBankCart()))
                    System.out.println("Your bank card is not registered");
                else {
                    Repayment repayment = repaymentList.stream().toList().get(number-1);
                    repayment.setPaid(true);
                    ApplicationContext.getRepaymentService().saveOrUpdate(repayment);
                }
            }
        }
    }

    }