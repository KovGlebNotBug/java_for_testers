import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TastBase {

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()){
            createGroup(new GroupData("group name", "group header", "group footer"));
        }
        removeGroup();
    }

}

