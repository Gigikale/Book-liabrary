package model;

public class User {
    private String name;
    private String idNumber;
    private String phoneNumber;
    private Role role;

    public User(String name, String idNumber, String phoneNumber, Role role) {
        this.name = name;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getIdNumber() {return idNumber;}

    public void setIdNumber(String idNumber) {this.idNumber = idNumber;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public Role getRole() {return role;}

    public void setRole(Role role) {this.role = role;}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\n' +
                ", idNumber='" + idNumber + '\n' +
                ", phoneNumber='" + phoneNumber + '\n' +
                ", role=" + role +
                '}' + "\n";
    }
}
