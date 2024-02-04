package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
                    "email@example.com"));
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
}
