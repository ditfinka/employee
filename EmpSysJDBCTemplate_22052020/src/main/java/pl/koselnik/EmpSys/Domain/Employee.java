package pl.koselnik.EmpSys.Domain;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.*;


public class Employee {

    public Long idEmployee;
    @NotNull
    @Size(min=3, max=30, message = "Imię musi mieć między 3, a 25 znaków.")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń0-9 ]+", message = "Imię nie może zawierać znaków specjalnych.")
    public String name;

    @NotNull
    @Size(min=3, max=30, message = "Nazwisko musi mieć między 3, a 30 znaków.")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń ]+", message = "Nazwisko nie może zawierać cyfr i znaków specjalnych.")
    public String surname;

    @NotNull
    @Size(min=5, max=40, message = "Nazwa stanowiska musi mieć  między 5, a 40 znaków.")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń .]+", message ="Nazwa stanowiska nie może zawierać cyfr i znaków specjalnych.")
    public String position;

    @NotNull(message = "Pole musi być wypełnione")
    @Range(min=16, max=100, message = "Wiek musi być z przedziału 16-100 lat")
    public Integer age;

    public Boolean active;

    @NotNull
    @Size(min=3, max=30, message = "Obywatelstwo musi mieć między 3, a 30 znaków")
    @Pattern(regexp = "[a-zA-Ząśćężźłóń0-9 ]+", message = "Obywatelstwo nie może zawierać znaków specjalnych.")
    public String nationality;

    public Employee() {
    }

    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
    }

    private Employee(String name, String surname, String position, Integer age, Boolean active, String nationality) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.age = age;
        this.active = active;
        this.nationality = nationality;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public static class EmployeeBuilder {
        private Long idEmployee;
        private String name;
        private String surname;
        private String position;
        private Integer age;
        private Boolean active;
        private String nationality;


        public EmployeeBuilder setIdEmployee(Long idEmployee) {
            this.idEmployee = idEmployee;
            return this;
        }

        public EmployeeBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        public EmployeeBuilder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public EmployeeBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Employee build() {
            return new Employee(name, surname, position, age, active, nationality);
        }
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getActive() {
        return active;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}