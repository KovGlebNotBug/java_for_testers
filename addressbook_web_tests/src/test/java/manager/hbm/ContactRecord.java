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
    public String phoneHome;
    @Column(name = "mobile")
    public String phoneMobile;
    @Column(name = "work")
    public String phoneWork;
    public String email;
    public String middlename = CommonFunctions.randomString(2);
    public String nickname = CommonFunctions.randomString(2);
    public String company = CommonFunctions.randomString(2);
    public String title = CommonFunctions.randomString(2);
    public String fax = CommonFunctions.randomString(2);
    public String email2 = CommonFunctions.randomString(2);
    public String email3 = CommonFunctions.randomString(2);
    public String homepage = CommonFunctions.randomString(2);

    public ContactRecord() {
    }

    public ContactRecord(
            int id,
            String firstname,
            String lastname,
            String address,
            String phoneHome,
            String phoneMobile,
            String phoneWork,
            String email
    ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        this.phoneWork = phoneWork;
        this.email = email;
    }

}
