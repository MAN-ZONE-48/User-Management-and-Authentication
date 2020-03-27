package id.project.skripsi.manzone.dto;

public class UserDTO {
    private String userId;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userGender;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserAddress() { return userAddress; }

    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    public String getUserGender() { return userGender; }

    public void setUserGender(String userGender) { this.userGender = userGender; }
}
