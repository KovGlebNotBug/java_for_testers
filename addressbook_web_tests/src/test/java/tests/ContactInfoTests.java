package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{

    @Test
    void testPhones(){
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData(
                    "",
                    "first name",
                    "last name",
                    "address test",
                    "phoneHomeTest123",
                    "phoneMobileTest456",
                    "phoneWorkTest789",
                    "email@example.com",
                    "email2@example.com"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.phoneHome(), contact.phoneMobile(), contact.phoneWork())
                        .filter(s -> s != null && ! "".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testAddress() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData(
                    "",
                    "first name",
                    "last name",
                    "address test",
                    "phoneHomeTest123",
                    "phoneMobileTest456",
                    "phoneWorkTest789",
                    "email@example.com",
                    "email2@example.com"));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var address = app.contacts().getAddressFromHomePage(contact);
        var expected = app.contacts().getAddressFromModificationPage(contact);
        Assertions.assertEquals(expected, address);
    }

    @Test
    void testEmails() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData(
                    "",
                    "first name",
                    "last name",
                    "address test",
                    "phoneHomeTest123",
                    "phoneMobileTest456",
                    "phoneWorkTest789",
                    "email@example.com",
                    "email2@example.com"));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var contactId = contact.id();
        var email = app.contacts().getEmailsFromHomePage(contact);
        var result = new HashMap<String, String>();
        result.put(contactId, email);
        var expected = app.contacts().getEmailsFromModificationPage(contact);
        Assertions.assertEquals(expected, result);
    }


}