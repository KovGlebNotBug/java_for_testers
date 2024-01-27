package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroupsList = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroupsList.size());
        var testData = new GroupData().withName("modified name");
        app.groups().modifyGroup(oldGroupsList.get(index),testData);
        var newGroupsList = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroupsList);
        expectedList.set(index, testData.withId(oldGroupsList.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroupsList.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroupsList, expectedList);
    }
}
