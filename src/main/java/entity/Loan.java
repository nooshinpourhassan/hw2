package entity;

import base.entity.BaseEntity;
import entity.enums.LoanEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class Loan extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    @NotNull
    private LoanEnum loanEnum;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Student student;
    @Column(name = "debt_balance")
    private double debtBalance;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    public Loan() {

    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanEnum=" + loanEnum +
                ", debtBalance=" + debtBalance +
                ", loanDate=" + loanDate +
                '}';
    }
}
