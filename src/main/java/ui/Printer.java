package ui;

import util.SecurityContext;

import java.util.List;

public class Printer {
    public static void printItem(String[] item, String title) {

        System.out.println("----------------------------");
        System.out.println("          " + title + "         ");
        System.out.println("----------------------------");
        for (int i = 0; i < item.length; i++) {
            System.out.println("|" + (i + 1) + " - " + item[i]);
        }
    }
    public static void printItemList(List list, String title) {

        System.out.println("----------------------------");
        System.out.println("          " + title + "         ");
        System.out.println("----------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("|" + (i + 1) + " - " + list.get(i));
        }
    }
    public static void printMessage(String input) {
        System.out.println(input);
    }
    public static void printProfile() {
        System.out.println("|---------------------------------");
        System.out.println("|>>HOME welcome dear " + SecurityContext.username);
        System.out.println("|");
    }
}
