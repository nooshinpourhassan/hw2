package entity;

import base.entity.BaseEntity;
import entity.enums.LoanEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class Loan extends BaseEntity<Long> {
    @NotNull
    private LoanEnum loanEnum;
    @OneToOne
    private Student student;
    @Column(name = "debt_balance")
    private double debtBalance;

    public Loan() {

    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanEnum=" + loanEnum +
                ", debtBalance=" + debtBalance +
                '}';
    }
}
