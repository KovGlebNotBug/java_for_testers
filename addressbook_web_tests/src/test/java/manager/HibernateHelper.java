package manager;

import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import model.ContactData;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    public List<GroupData> getGroupList() {
        return convertGroupList(sessionFactory.fromSession(session -> {
           return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertToGroupRecord(groupData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactList() {
        return convertContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    public long getContactCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertToContactRecord(contactData));
            session.getTransaction().commit();
        });
    }

    static List<GroupData> convertGroupList(List<GroupRecord> records) {
        List<GroupData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertGroup(record));
        }
        return result;
    }

    private static GroupData convertGroup(GroupRecord record) {
        return new GroupData(
                "" + record.id,
                record.name,
                record.header,
                record.footer);
    }

    public GroupRecord convertToGroupRecord(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    static List<ContactData> convertContactList(List<ContactRecord> records) {
        List<ContactData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertContact(record));
        }
        return result;
    }

    private static ContactData convertContact(ContactRecord record) {
        return new ContactData(
                "" + record.id,
                record.firstname,
                record.lastname,
                record.address,
                record.phone,
                record.email);

//        return new ContactData().withId("" + record.id)
//                .withFirstName(record.firstname)
//                .withLastName(record.lastname)
//                .withAddress(record.address)
//                .withPhone(record.phone)
//                .withEmail(record.email);
    }

    public ContactRecord convertToContactRecord(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(
                Integer.parseInt(id),
                data.firstName(),
                data.lastName(),
                data.address(),
                data.phone(),
                data.email());
    }

    public List<ContactData> getContactInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }

    public void addContactToGroup (GroupRecord groupRecord, ContactRecord contactRecord) {
        groupRecord.contacts.add(contactRecord);
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.update(groupRecord);
            session.getTransaction().commit();
        });
    }
}
