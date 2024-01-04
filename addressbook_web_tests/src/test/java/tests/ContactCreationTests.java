package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {


    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("first name", "last name", "address test", "phone test 123", "email@example.com"));
    }

    @Test
    public void canCreateContactWithEmptyData() {
        app.contacts().createContact(new ContactData("", "", "", "", ""));
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("some name"));
    }

}
