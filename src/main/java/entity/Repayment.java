package entity;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class Repayment extends BaseEntity<Long> {
    private int number;

    private LocalDate repaymentDate;

    private double instalment;
    @ManyToOne
    private Loan loan;

    private boolean paid;
    public Repayment() {

    }

    @Override
    public String toString() {
        return "Repayment{" +
                "number=" + number +
                ", instalment=" + instalment +
                ", loan=" + loan +
                '}';
    }
}
