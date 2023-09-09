package entity;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class BankCart extends BaseEntity<Long> {
    @OneToOne
    private Student student;

    @Pattern(regexp = "^\\d{16}$", message = "cart number must be a 16-digit number")
    private String cartNumber;
    @Future(message = "cart year must be future")
    private Year year;

    @Pattern(regexp="^(?:[1-9]|[12][0-9]|3[01])$")
    private int day;

    private int cvv2;

    public BankCart() {

    }
}
