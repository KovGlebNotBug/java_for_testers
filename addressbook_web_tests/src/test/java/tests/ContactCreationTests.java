import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactCreationTests extends TestBase {


    @Test
    public void canCreateContact() {
        openContactsPage();
        createContact("first name", "last name", "address test", "phone test 123", "email@example.com" );
    }

    @Test
    public void canCreateContactWithEmptyData() {
        openContactsPage();
        createContact("","","","","");
    }

}
