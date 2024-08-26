package cmsc256;

import java.time.LocalDate;
/**
 * Jacob Turner
 *
 * Purpose is to show the use of inheritance in source code
 */

public class Employee extends Person{
    //Instance variables
    private String office;
    private int salary;
    private LocalDate hireDate;

    //Default constructor
    public Employee(){
        super();
        setOffice("");
        setSalary(0);
        this.hireDate = null;
    }
    public Employee(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office, int salary, int month, int day, int year){
        super(first, middle, last, homeAddress, phoneNumber, email);
        setOffice(office);
        setSalary(salary);

        if(month>0 && day > 0 && year>0){
            this.hireDate = LocalDate.of(year,month,day);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }


    //toString override
    public String toString() {
        if(this.hireDate!=null) {
            return "Employee:\n" + super.toString() + "Office: " + this.office + "\nSalary: $" + this.salary +
                    "\nDate Hired: " + getHireDate().getMonthValue() +"/" + getHireDate().getDayOfMonth() + "/" + getHireDate().getYear() + "\n";
        }
        else{
            return "Employee:\n" + super.toString() + "Office: " + this.office + "\nSalary: $" + this.salary +
                    "\nDate Hired: Not available";
        }
        }


}

