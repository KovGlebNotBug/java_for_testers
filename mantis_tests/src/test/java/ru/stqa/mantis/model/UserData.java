package ru.stqa.mantis.model;

public record UserData(String username, String userEmail, String userPassword) {

    public UserData() {
        this("", "", "");
    }

    public UserData withUsername(String username) {
        return new UserData(username, this.userEmail, this.userPassword);
    }

    public UserData withUserEmail(String userEmail) {
        return new UserData(this.username, userEmail, this.userPassword);
    }

    public UserData withUserPassword(String userPassword) {
        return new UserData(this.username, this.userEmail, userPassword);
    }
}
