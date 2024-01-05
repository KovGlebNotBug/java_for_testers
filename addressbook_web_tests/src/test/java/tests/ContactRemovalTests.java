package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactCount() == 0 ) {
            app.contacts().createContact(new ContactData("first name", "last name", "address test", "phone test 123", "email@example.com"));
        }
        int contactCount = app.contacts().getContactCount();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

}
