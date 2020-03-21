package id.project.skripsi.manzone.dto;

public class UserProfileDTO {

    private String userName;
    private String userPhone;
    private String userEmail;
    private String userProfilePicture;
    private int userAge;
    private String userGender;


    public static class Builder{
        private String userName;
        private String userPhone;
        private String userEmail;
        private String userProfilePicture;
        private int userAge;
        private String userGender;

        public Builder(String userName) {
            this.userName = userName;

        }

        public Builder withEmail(String userEmail){
            this.userEmail = userEmail;
            return this;
        }

        public Builder withPhoneNumber(String userPhone){
            this.userPhone = userPhone;
            return this;
        }

        public Builder withProfilePicture(String userProfilePicture){
            this.userProfilePicture = userProfilePicture;
            return this;
        }

        public Builder withAge(int userAge){
            this.userAge = userAge;
            return this;
        }

        public Builder withGender(String userGender){
            this.userGender = userGender;
            return this;
        }

        public UserProfileDTO build(){
            return new UserProfileDTO(this);
        }

    }

    private UserProfileDTO(Builder builder){
        this.userName = builder.userName;
        this.userEmail = builder.userEmail;
        this.userPhone = builder.userPhone;
        this.userAge = builder.userAge;
        this.userProfilePicture = builder.userProfilePicture;
        this.userGender = builder.userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
