package id.project.skripsi.manzone.dto;

public class UserProfileDTO {

    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPassword;


    public static class Builder{
        private String userName;
        private String userPhone;
        private String userEmail;
        private String userPassword;

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

        public Builder withPassword(String userPassword){
           this.userPassword = userPassword;
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
}
