package ru.stqa.mantis.model;

public record UserData(
        String username,
        String userRealName,
        String userEmail,
        String userPassword

) {

    public UserData() {
        this("", "", "", "");
    }

    public UserData withUsername(String username) {
        return new UserData(username, this.userRealName, this.userEmail, this.userPassword);
    }

    public UserData withUserEmail(String userEmail) {
        return new UserData(this.username, this.userRealName, userEmail, this.userPassword);
    }

    public UserData withUserPassword(String userPassword) {
        return new UserData(this.username, this.userRealName, this.userEmail, userPassword);
    }

    public UserData withUserRealName(String userRealName) {
        return new UserData(this.username, userRealName, this.userEmail, userPassword);
    }
}
