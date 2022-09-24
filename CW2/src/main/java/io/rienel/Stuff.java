package io.rienel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.24
 */
public class Stuff {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private String position;
    private Integer salary;
    private LocalDateTime hireDate;

    public Stuff() {
    }

    public Stuff(UUID id,
                 String surname,
                 String name,
                 String patronymic,
                 LocalDate birthDate,
                 String position,
                 Integer salary,
                 LocalDateTime hireDate) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate=" + birthDate +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
