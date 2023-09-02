package entity;

import base.entity.BaseEntity;
import entity.enums.GradeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Year;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class Student extends BaseEntity<Long> {
    @Pattern(regexp = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*$", message = "Invalid first name format")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*$", message = "Invalid first name format")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*$", message = "Invalid first name format")
    private String fatherName;

    @Pattern(regexp = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*$", message = "Invalid first name format")
    private String motherName;
    @Pattern(regexp = "^\\d{10}$", message = "National code must be a 10-digit number")
    private String nationalCode;
    @Past(message = "Year must be in the past")
    private LocalDate birthdate;
    @Pattern(regexp = "^\\d{10}$", message = "Student number must be a 10-digit number")
    private String studentNumber;
    @PastOrPresent(message = "Year must be in the past or present")
    private Year enteringYear;

    private GradeEnum gradeEnum;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;


    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthdate=" + birthdate +
                ", studentNumber='" + studentNumber + '\'' +
                ", enteringYear=" + enteringYear +
                ", gradeEnum=" + gradeEnum +
                ", university=" + university +
                '}';
    }
}
