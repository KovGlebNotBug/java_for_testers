import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        openContactsPage();
        if (!isContactPresent()) {
            createContact("first name", "last name", "address test", "phone test 123", "email@example.com");
        }
        removeContact();
    }

}
