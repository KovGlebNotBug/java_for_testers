package manager;


import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void removeContact(ContactData contact) {
        openContactsPage();
        selectContact(contact);
        submitRemoveContact();
    }

    public void modifyContact(ContactData contact, ContactData modifyContact) {
        openContactsPage();
        initContactModification(contact);
        fillContactForm(modifyContact);
        submitContactModification();
        returnToHomePage();

    }

    private void fillContactForm(ContactData contact) {
        click(By.name("firstname"));
        type(By.name("firstname"), contact.firstName());
        click(By.name("lastname"));
        type(By.name("lastname"), contact.lastName());
        click(By.name("address"));
        type(By.name("address"), contact.address());
        click(By.name("home"));
        type(By.name("home"), contact.phoneHome());
        click(By.name("mobile"));
        type(By.name("mobile"), contact.phoneMobile());
        click(By.name("work"));
        type(By.name("work"), contact.phoneWork());
        click(By.name("email"));
        type(By.name("email"), contact.email());
    }

    public void addContactToGroup(GroupData group, ContactData contact) {
        openContactsPage();
        selectContact(contact);
        selectGroupForAddingContact(group);
        submitAddContactToGroup();
    }

    public void canRemoveContactFromGroup(GroupData group, ContactData contact) {
        openContactsPage();
        selectGroupForView(group);
        selectContact(contact);
        submitRemovingContactFromGroup();
    }

    public String getPhones(ContactData contact) {
        openContactsPage();
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public int getContactCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("searchstring"))) {
            manager.driver.get("http://localhost/addressbook/");
        }
        click(By.linkText("home"));
    }

    private void selectContact(ContactData contact) {
        click(By.xpath(String.format("//td[./input[@id='%s']]", contact.id())));
    }

    private void submitRemoveContact() {
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
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

    public List<ContactData> getList() {
        openContactsPage();
        var contacts = new ArrayList<ContactData>();
        var trTags = manager.driver.findElements(By.xpath("//tr[@name='entry']"));
        for (var trTag : trTags) {
            var lastName = trTag.findElement(By.xpath("td[2]")).getText();
            var firstName = trTag.findElement(By.xpath("td[3]")).getText();
            var id = trTag.findElement(By.name("selected[]")).getAttribute("id");
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }


    private void submitContactModification() {
        click(By.xpath("//input[@name='update'][2]"));
    }

    private void initContactModification(ContactData contact) {
        click(By.xpath(String.format("//td[./input[@id='%s']]/..//td//a//img[@title='Edit']", contact.id())));
    }

    private void submitAddContactToGroup() {
        click(By.xpath("//input[@name='add']"));

    }

    private void selectGroupForAddingContact(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());

    }

    private void submitRemovingContactFromGroup() {
        click(By.name("remove"));
    }

    private void selectGroupForView(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    public Map<String, String> getPhones() {
        openContactsPage();
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute(("id"));
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }
}
