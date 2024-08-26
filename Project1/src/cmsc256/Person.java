package cmsc256;

/**
 * Jacob Turner
 *
 * Purpose is to show the use of inheritance in source code
 */
public class Person {
    private int id;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    private static int recordNumber;

    //Default constructor
    public Person(){
        recordNumber++;
        this.name = new Name();
        this.id= recordNumber;
        this.homeAddress = new Address();
        this.email = "None given";
        this.phoneNumber = "None given";
    }
    //Parametrized constructor
    public Person(String first, String middle, String last, Address homeAddress, String phoneNumber, String email){

        this.name = new Name(first,middle,last);
        setHomeAddress(homeAddress);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        recordNumber++;
        setId(recordNumber);

    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    //toString override
    public String toString(){
        return "---------------------------------------\n" + this.name.toString() + "\n---------------------------------------\nHome Address: " + this.homeAddress.toString() + "\nPhone Number: " + this.phoneNumber + "\nEmail Address: " + this.email + "\nID: " + this.id  + "\n";
    }
}
