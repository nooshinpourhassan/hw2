package entity;

import base.entity.BaseEntity;
import entity.enums.UniversityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class University extends BaseEntity<Long> {
    @Pattern(regexp = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*$", message = "Invalid first name format")
    private String name;

    private UniversityEnum universityEnum;

    @OneToMany(mappedBy = "university")
    private List<Student> student;

    public University() {
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", universityEnum=" + universityEnum +
                '}';
    }
}
