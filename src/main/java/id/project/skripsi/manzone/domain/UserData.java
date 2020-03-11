package id.project.skripsi.manzone.domain;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_enabled")
    private boolean userEnable;

    @Column(name = "user_password")
    private String userPassword;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<UserRole> userRole;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public boolean isUserEnable() { return userEnable; }

    public void setUserEnable(boolean userEnable) { this.userEnable = userEnable; }

    public List<UserRole> getUserRole() { return userRole; }

    public void setUserRole(List<UserRole> userRole) { this.userRole = userRole; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return userEnable == userData.userEnable &&
                userId.equals(userData.userId) &&
                userName.equals(userData.userName) &&
                Objects.equals(userAddress, userData.userAddress) &&
                userGender.equals(userData.userGender) &&
                Objects.equals(userPhone, userData.userPhone) &&
                userPassword.equals(userData.userPassword) &&
                userRole.equals(userData.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userAddress, userGender, userPhone, userEnable, userPassword, userRole);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEnable=" + userEnable +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}

