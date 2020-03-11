package id.project.skripsi.manzone.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private String userRoleId;

    @Column(name = "user_role")
    private String userRoleName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private UserData userData;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return userRoleId.equals(userRole.userRoleId) &&
                userRoleName.equals(userRole.userRoleName) &&
                userData.equals(userRole.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, userRoleName, userData);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId='" + userRoleId + '\'' +
                ", userRoleName='" + userRoleName + '\'' +
                ", userData=" + userData +
                '}';
    }
}
