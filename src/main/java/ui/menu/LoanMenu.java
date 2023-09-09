package ui.menu;

import ui.Printer;
import util.Constant;
import util.SecurityContext;

import static ui.menu.Menu.scanner;


public class LoanMenu {
    public void loanMenu() {
        Printer.printProfile();
        boolean flag = true;
        while (flag) {
            Printer.printItem(Constant.loanMenu, "Choose one... ");
            String chosenItem = scanner.next();
            switch (chosenItem) {
                case "1" -> {
                    receiveLoan();
                    break;
                }
                case "2" -> {
                    repaymentLoan();
                    break;
                }
                case "3" -> {
                    signOut();
                    flag = false;
                }
                default -> Printer.printMessage("Wrong input");
            }
        }
    }

    private void signOut() {
        SecurityContext.id = 0L;
        SecurityContext.username = "";
    }

    private void repaymentLoan() {
        
    }

    private void receiveLoan() {
        boolean flag = true;
        while (flag) {
            Printer.printItem(Constant.receiveLoan, "Choose one... ");
            String chosenItem = scanner.next();
            switch (chosenItem) {
                case "1" -> {
                    ReceiveLoan.tuitionLoan();
                    break;
                }
                case "2" -> {
                    ReceiveLoan.educationLoan();
                    break;
                }
                case "3" -> {
                    ReceiveLoan.housingLoan();
                    break;
                }
                case "4" -> {
                    flag = false;
                }
                default -> Printer.printMessage("Wrong input");
            }
        }
    }
}