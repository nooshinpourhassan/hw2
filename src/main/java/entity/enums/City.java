package entity.enums;

public enum City {
    TEHRAN(32000000),
    METROPOLISES(2600000),
    OTHER_CITY(19500000);

    private int loan;

    private City(int loan) {
        this.loan = loan;
    }

    public int getLoan() {
        return loan;
    }
}