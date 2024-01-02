import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TastBase {

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()){
            createGroup("group name", "group header", "group footer");
        }
        removeGroup();
    }

}

