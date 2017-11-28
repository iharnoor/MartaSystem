package SignUpPage;

public class UserData {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String martaCardNo;
    private String phoneNo;

    public UserData(String userName, String password, String firstName, String lastName, String martaCardNo, String phoneNo) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.martaCardNo = martaCardNo;
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMartaCardNo() {
        return martaCardNo;
    }

    public void setMartaCardNo(String martaCardNo) {
        this.martaCardNo = martaCardNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
