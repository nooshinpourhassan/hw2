package entity;

import base.entity.BaseEntity;
import entity.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Information extends BaseEntity<Long> {
    @OneToOne(cascade = CascadeType.PERSIST )
    private Student student;

    private String address;

    private String wifeNationalCode;

    private String housingRentalNumber;

    private City city;

    public Information() {

    }
}
