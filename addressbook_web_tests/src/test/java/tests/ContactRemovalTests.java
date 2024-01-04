package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("first name", "last name", "address test", "phone test 123", "email@example.com"));
        }
        app.contacts().removeContact();
    }

}
