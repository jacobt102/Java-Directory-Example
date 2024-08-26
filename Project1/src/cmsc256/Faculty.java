package cmsc256;

/**
 * Jacob Turner
 *
 * Purpose is to show the use of inheritance in source code
 */

public class Faculty extends Employee{
    private String rank;

    //Constructors
    public Faculty(){
        super();
        setRank("");

    }

    public Faculty(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office, int salary, int month, int day, int year, String rank){
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);

        if(isValidRank(rank)){
            this.rank = rank;
        }
    }

    //Getter and setter
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    //Checking if rank input is valid and throws exception otherwise
    private boolean isValidRank(String rank){
        if(rank.equals("Adjunct") || rank.equals("Instructor")||rank.equals("Assistant Professor")||rank.equals("Associate Professor")||rank.equals("Professor")){
            return true;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    //toString override
    @Override
    public String toString() {
        return "Faculty:\n" + super.toString() + "Rank: " + this.rank + "\n";
    }
}
