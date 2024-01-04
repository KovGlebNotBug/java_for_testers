package manager;


import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact() {
        openContactsPage();
        selectContact();
        submitRemoveContact();
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("searchstring"))) {
            manager.driver.get("http://localhost/addressbook/");
        }
    }

    private void selectContact() {
        manager.driver.findElement(By.name("selected[]")).click();
    }

    private void submitRemoveContact() {
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void initContactCreation() {
        manager.driver.findElement(By.linkText("add new")).click();
    }

    private void submitContactCreation() {
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    private void returnToHomePage() {
        manager.driver.findElement(By.linkText("home page")).click();
    }

    private void fillContactForm(ContactData contact) {
        click(By.name("firstname"));
        type(By.name("firstname"), contact.firstName());
        click(By.name("lastname"));
        type(By.name("lastname"), contact.lastName());
        click(By.name("address"));
        type(By.name("address"), contact.address());
        click(By.name("home"));
        type(By.name("home"), contact.phone());
        click(By.name("email"));
        type(By.name("email"), contact.email());
    }
}
