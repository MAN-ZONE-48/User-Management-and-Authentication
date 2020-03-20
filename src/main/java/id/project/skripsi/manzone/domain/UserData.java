package id.project.skripsi.manzone.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "user_data")
public class UserData{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "last_modified")
    private Date lastModified;

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

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_dob")
    private Date userDob;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private List<UserRole> userRole;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private UserDataProfile userDataProfile;

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

    public Date getUserDob() { return userDob; }

    public void setUserDob(Date userDob) { this.userDob = userDob; }

    public UserDataProfile getUserDataProfile() { return userDataProfile; }

    public void setUserDataProfile(UserDataProfile userDataProfile) { this.userDataProfile = userDataProfile; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getLastModified() { return lastModified; }

    public void setLastModified(Date lastModified) { this.lastModified = lastModified; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return userEnable == userData.userEnable &&
                id.equals(userData.id) &&
                createdAt.equals(userData.createdAt) &&
                lastModified.equals(userData.lastModified) &&
                userName.equals(userData.userName) &&
                Objects.equals(userAddress, userData.userAddress) &&
                userGender.equals(userData.userGender) &&
                Objects.equals(userPhone, userData.userPhone) &&
                userPassword.equals(userData.userPassword) &&
                userDob.equals(userData.userDob) &&
                userRole.equals(userData.userRole) &&
                userDataProfile.equals(userData.userDataProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, lastModified, userName, userAddress, userGender, userPhone, userEnable, userPassword, userDob, userRole, userDataProfile);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEnable=" + userEnable +
                ", userPassword='" + userPassword + '\'' +
                ", userDob=" + userDob +
                ", userRole=" + userRole +
                ", userDataProfile=" + userDataProfile +
                '}';
    }
}

