package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import common.CommonFunctions;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String address;
    @Column(name = "home")
    public String phone;
    public String email;
    public String middlename = CommonFunctions.randomString(2);
    public String nickname = CommonFunctions.randomString(2);
    public String company = CommonFunctions.randomString(2);
    public String title = CommonFunctions.randomString(2);
    public String mobile = CommonFunctions.randomString(2);
    public String work = CommonFunctions.randomString(2);
    public String fax = CommonFunctions.randomString(2);
    public String email2 = CommonFunctions.randomString(2);
    public String email3 = CommonFunctions.randomString(2);
    public String homepage = CommonFunctions.randomString(2);

    public ContactRecord() {
    }

    public ContactRecord( int id, String firstname, String lastname, String address, String phone, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
