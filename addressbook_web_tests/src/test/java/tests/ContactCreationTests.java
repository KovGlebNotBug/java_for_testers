package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        // this part of the code has been commented out because it generates too many tests
        /*for (var firstName : List.of("", "first name")) {
            for (var lastName : List.of("", "last name")) {
                for (var address : List.of("", "address")) {
                    for (var phone : List.of("", "12345678")) {
                        for (var email : List.of("", "email@example.com"))
                            result.add(new ContactData(firstName, lastName, address, phone, email));
                    }
                }
            }
        }*/
        XmlMapper mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContactsList = app.contacts().getContactList();
        app.contacts().createContact(contact);
        var newContactList = app.contacts().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContactList.sort(compareById);
        var expectedList = new ArrayList<>(oldContactsList);
        expectedList.add(contact.withId(newContactList.get(newContactList.size() - 1).id()).withAddress("").withPhone("").withEmail(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContactList, expectedList);
    }

}
