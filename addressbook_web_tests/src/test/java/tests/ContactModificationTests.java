package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getContactCount() == 0) {
            app.contacts().createContact(new ContactData("", "first name", "last name", "address test", "phone test 123", "email@example.com"));
        }
        var oldContactsList = app.contacts().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContactsList.size());
        var testData = new ContactData().withFirstName("NEW first name").withLastName("NEW last name");
        app.contacts().modifyContact(oldContactsList.get(index), testData);
        var newContactList = app.contacts().getContactList();
        var expectedList = new ArrayList<>(oldContactsList);
        expectedList.set(index, testData.withId(oldContactsList.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContactList.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContactList, expectedList);

    }
}
