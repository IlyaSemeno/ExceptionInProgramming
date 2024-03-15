
public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String[] data) throws InvalidDataFormatException {
        if (data.length != 6) {
            throw new InvalidDataFormatException("Invalid number of data elements provided.");
        }
        this.lastName = data[0];
        this.firstName = data[1];
        this.middleName = data[2];
        this.birthDate = data[3];
        try {
            this.phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Phone number should be an unsigned integer.");
        }
        if (data[5].length() != 1 || (!data[5].equals("f") && !data[5].equals("m"))) {
            throw new InvalidDataFormatException("Gender should be 'f' or 'm'.");
        }
        this.gender = data[5].charAt(0);
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
