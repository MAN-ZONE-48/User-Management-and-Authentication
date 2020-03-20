package id.project.skripsi.manzone.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_data_profile")
public class UserDataProfile{

    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id"
    )
    private String id;
    @Column(
            name = "created_at"
    )
    @CreatedDate
    private Date createdAt;
    @Column(
            name = "last_modified"
    )
    @LastModifiedDate
    private Date lastModified;

    @Column(name = "user_full_name")
    private String userFullName;

    @Column(name = "user_profile_picture")
    private String userProfilePicture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataProfile that = (UserDataProfile) o;
        return id.equals(that.id) &&
                createdAt.equals(that.createdAt) &&
                lastModified.equals(that.lastModified) &&
                Objects.equals(userFullName, that.userFullName) &&
                Objects.equals(userProfilePicture, that.userProfilePicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, lastModified, userFullName, userProfilePicture);
    }

    @Override
    public String toString() {
        return "UserDataProfile{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                ", userFullName='" + userFullName + '\'' +
                ", userProfilePicture='" + userProfilePicture + '\'' +
                '}';
    }
}
