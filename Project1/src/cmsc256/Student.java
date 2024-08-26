package cmsc256;

/**
 * Jacob Turner
 *
 * Purpose is to show the use of inheritance in source code
 */

public class Student extends Person{
    private String level;

    //Constructors
    public Student(){
        super();
        this.level = "Freshman";

    }
    public Student(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String level){
        super(first, middle, last, homeAddress, phoneNumber, email);
        //Checking if level is a valid input
        if(isValidLevel(level)){
            this.level = level;
        }

    }
    //throws an exception if level input ins't valid
    private boolean isValidLevel(String level){
        if(level.equals("Freshman") || level.equals("Sophomore") || level.equals("Junior") || level.equals("Senior") || level.equals("Graduate")){
            return true;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    //Getters and setters
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    //toString override
    public String toString(){
        return "Student:\n" + super.toString() + "Student Level: " + this.level + "\n";
    }
}
