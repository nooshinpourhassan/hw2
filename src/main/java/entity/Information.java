package entity;

import base.entity.BaseEntity;
import entity.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Information extends BaseEntity<Long> {
    @OneToOne(cascade = CascadeType.PERSIST )
    private Student student;

    private String address;

    @Column(unique = true)
    @Pattern(regexp = "^\\d{5}$", message = "National code must be a 6-digit number")
    private String partnerNationalCode;

    @Column(unique = true)
    @Pattern(regexp = "^\\d{6}$", message = "National code must be a 6-digit number")
    private String housingRentalNumber;

    @Enumerated(EnumType.STRING)
    private City city;

    public Information() {

    }

    @Override
    public String toString() {
        return "Information{" +
                "student=" + student +
                ", address='" + address + '\'' +
                ", partnerNationalCode='" + partnerNationalCode + '\'' +
                ", housingRentalNumber='" + housingRentalNumber + '\'' +
                ", city=" + city +
                '}';
    }
}
