package util.tm;

public class RegistrationTM {
    private String id ;
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private String date;

    public RegistrationTM(String id, String firstName, String lastName, String address, int age, String date) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setAge(age);
        this.setDate(date);
    }

    public RegistrationTM() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegistrationTM{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", date='" + date + '\'' +
                '}';
    }
}
