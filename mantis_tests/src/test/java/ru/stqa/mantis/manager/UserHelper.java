package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }


    public void createNewAccount(String username, String userEmail) {
        openManagerBar();
        openManagerUsersTab();
        initCreateNewAccount();
        fillNewAccountForm(username, userEmail);
        submitNewAccountCreation();






    }

    private void submitNewAccountCreation() {
        click(By.cssSelector("input[class='btn btn-primary btn-white btn-round']"));
    }

    private void fillNewAccountForm(String username, String userEmail) {
        click(By.cssSelector("input[id='user-username']"));
        type(By.cssSelector("input[id='user-username']"), username);
        click(By.cssSelector("input[id='email-field']"));
        type(By.cssSelector("input[id='email-field']"), userEmail);


    }

    private void initCreateNewAccount() {
        click(By.cssSelector("a[class='btn btn-primary btn-white btn-round btn-sm'"));
    }

    private void openManagerUsersTab() {
        click(By.cssSelector("a[href='/mantisbt-2.25.8/manage_user_page.php']"));
    }

    private void openManagerBar() {
        click(By.cssSelector("i[class='fa fa-gears menu-icon']"));
    }
}
