package dspe;

public class Contact {

    private String number;
    private Name Name;
    private char gender;

    public Contact(String number, Name Name, char gender) {
        this.number = number;
        this.Name = Name;
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Name getName() {
        return Name;
    }

    public void setName(Name Name) {
        this.Name = Name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Contact{" + "number=" + number + ", Name=" + Name + '}';

    }
}
