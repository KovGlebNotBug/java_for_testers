package manager;

import model.ContactData;
import model.GroupData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {

    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    private static final String DB_URL = "jdbc:mysql://localhost/addressbook";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static Connection getConnectionToDB() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();
        try (var conn = getConnectionToDB();
             var statement = conn.createStatement();
             var result = statement.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list")) {
            while (result.next()) {
                groups.add(new GroupData()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<ContactData> getContactList() {
        var contacts = new ArrayList<ContactData>();
        try (var conn = getConnectionToDB();
             var statement = conn.createStatement();
             var result = statement.executeQuery("SELECT id, firstname, lastname, address, home, email FROM addressbook")) {
            while (result.next()) {
                contacts.add(new ContactData()
                        .withId(result.getString("id"))
                        .withFirstName(result.getString("firstname"))
                        .withLastName(result.getString("lastname"))
                        .withAddress(result.getString("address"))
                        .withPhone(result.getString("home"))
                        .withEmail(result.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}
