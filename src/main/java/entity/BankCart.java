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
    @OneToOne(mappedBy = "bankCart")
    private Student student;

    @Pattern(regexp = "^(603799|589463|627353|628023)[0-9]{10}$", message = "cart number must be a 16-digit and Refah ,Maskan,Tejarat or Melli Bank")
    private String cartNumber;
    @Future(message = "cart year must be future")
    @Pattern(regexp = "^[0-9]{4}$")
    private Year year;

    @Pattern(regexp = "^(0?[1-9]|[1-2][0-9]|3[0-1])$" , message = "day must be 1-31")
    private int day;

    @Pattern(regexp = "^[0-9]{3,4}$", message = "cvv2 must be 3 or 4 digit")
    private int cvv2;

    public BankCart() {

    }
}
