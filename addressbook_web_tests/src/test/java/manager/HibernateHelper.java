package manager;

import io.qameta.allure.Step;
import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import model.ContactData;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

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

    @Step
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

    @Step
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

    /**
     * пример функционального стиля написания кода.
     * в императивном стиле, код выглядел так
     * List<GroupData> result = new ArrayList<>();
     *         for (var record : records) {
     *             result.add(convertGroup(record));
     *         }
     *         return result;
     */
    static List<GroupData> convertGroupList(List<GroupRecord> records) {
        return records.stream().map(HibernateHelper::convertGroup).collect(Collectors.toList());
    }

    private static GroupData convertGroup(GroupRecord record) {
        return new GroupData(
                "" + record.id,
                record.name,
                record.header,
                record.footer);
    }

    public static GroupRecord convertToGroupRecord(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    /**
     * пример функционального стиля написания кода.
     * в императивном стиле, код выглядел так
     * List<ContactData> result = new ArrayList<>();
     *         for (var record : records) {
     *             result.add(convertContact(record));
     *         }
     *         return result;
     */
    static List<ContactData> convertContactList(List<ContactRecord> records) {
        return records.stream().map(HibernateHelper::convertContact).collect(Collectors.toList());
    }

    private static ContactData convertContact(ContactRecord record) {
        return new ContactData(
                "" + record.id,
                record.firstname,
                record.lastname,
                record.address,
                record.phoneHome,
                record.phoneMobile,
                record.phoneWork,
                record.email,
                record.email2);

//        return new ContactData().withId("" + record.id)
//                .withFirstName(record.firstname)
//                .withLastName(record.lastname)
//                .withAddress(record.address)
//                .withPhone(record.phoneHome)
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
                data.phoneHome(),
                data.phoneMobile(),
                data.phoneWork(),
                data.email(),
                data.email2());
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