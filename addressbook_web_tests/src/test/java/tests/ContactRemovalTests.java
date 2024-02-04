package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("",
                    "first name",
                    "last name",
                    "address test",
                    "phoneHomeTest123",
                    "phoneMobileTest456",
                    "phoneWorkTest789",
                    "email@example.com",
                    "email2@example.com"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContactList = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContactList, expectedList);
    }

}