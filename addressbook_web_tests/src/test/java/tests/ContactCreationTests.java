package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(20))
                .withAddress(CommonFunctions.randomString(30))
                .withPhone(CommonFunctions.randomString(10))
                .withEmail(CommonFunctions.randomString(10)));
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateContact(ContactData contact) {
        var oldContactsList = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContactList = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContactList.sort(compareById);
        var maxId = newContactList.get(newContactList.size() - 1).id();

        var expectedList = new ArrayList<>(oldContactsList);
        expectedList.add(contact.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContactList, expectedList);
    }

    @Test
    public void canAddContactToGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address test", "phone test 123", "email@example.com"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var contact = app.hbm().getContactList().get(0);
        var group = app.hbm().getGroupList().get(0);
        var contactInGroup = app.hbm().getContactInGroup(group).contains(contact);
        if (contactInGroup) {
            app.contacts().canRemoveContactFromGroup(group, contact);
        }
        var oldRelated = app.hbm().getContactInGroup(group);
        app.contacts().addContactToGroup(contact, group);
        var newRelated = app.hbm().getContactInGroup(group);

        var expectedList = new ArrayList<>(oldRelated);
        expectedList.add(contact);
        Assertions.assertEquals(newRelated, expectedList);
    }

    @Test
    public void canRemoveContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address test", "phone test 123", "email@example.com"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var contact = app.hbm().getContactList().get(0);
        var group = app.hbm().getGroupList().get(0);
        var contactInGroup = app.hbm().getContactInGroup(group).contains(contact);
        if (!contactInGroup) {
            app.contacts().addContactToGroup(contact, group);
        }
        var oldRelated = app.hbm().getContactInGroup(group);
        app.contacts().canRemoveContactFromGroup(group, contact);
        var newRelated = app.hbm().getContactInGroup(group);

        var expectedList = new ArrayList<>(oldRelated);
        expectedList.remove(contact);
        Assertions.assertEquals(newRelated, expectedList);
    }
}
