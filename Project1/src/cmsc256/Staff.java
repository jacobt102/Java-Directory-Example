package cmsc256;

/**
 * Jacob Turner
 *
 * Purpose is to show the use of inheritance in source code
 */
public class Staff extends Employee{
    private String title;
    //Constructors
    public Staff(){
        super();
        setTitle("");

    }
    public Staff(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office, int salary, int month, int day, int year, String title){
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        this.title = title;
    }

    //Getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //toString override
    public String toString() {
        return "Staff:\n" + super.toString() + "Title: " + this.getTitle() + "\n";
    }
}
