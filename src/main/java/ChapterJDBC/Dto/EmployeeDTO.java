package ChapterJDBC.Dto;


import java.math.BigDecimal;

public class EmployeeDTO {
    private String fName;
    private String lName;
    private String gender;
    private String salary;
    private BigDecimal birthDay;

    private EmployeeDTO(String fName, String lName, String gender, String salary, BigDecimal birthDay) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.salary = salary;
        this.birthDay = birthDay;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String fName;
        private String lName;
        private String gender;
        private String salary;
        private BigDecimal birthDay;

        public EmployeeDTO build() {
            return new EmployeeDTO(fName, lName, gender, salary, birthDay);
        }

        public Builder setBirthDay(BigDecimal birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder setSsalary(String salary) {
            this.salary = salary;
            return this;
        }

        public Builder setFName(String fName) {
            this.fName = fName;
            return this;
        }

        public Builder setLName(String lName) {
            this.lName = lName;
            return this;
        }

        public Builder setGender() {
            this.gender = gender;
            return this;
        }
    }
}
