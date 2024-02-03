package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of("", "group name")) {
//            for (var header : List.of("", "header name")) {
//                for (var footer : List.of("", "footer name")) {
//                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
//                }
//            }
//        }
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static Stream<GroupData> randomGroups() {
        Supplier<GroupData> randomGroup = () -> new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(20))
                .withFooter(CommonFunctions.randomString(30));
        return Stream.generate(randomGroup).limit(3);
    }

    @ParameterizedTest
    @MethodSource("randomGroups")
    public void canCreateGroup(GroupData group) {
        var oldGroups = app.hbm().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();

        // вместо сравнения "списков" используется сравнение "множества"
        // что позволяет не использовать функцию сортировки
//        Comparator<GroupData> compareById = (o1, o2) -> {
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
//        };
//        newGroups.sort(compareById);

        var extraGroups = newGroups.stream().filter(g -> ! oldGroups.contains(g)).toList();
        var newId = extraGroups.get(0).id();

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newId));
//        expectedList.sort(compareById);
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));

        // *extra task
        // comparing of list from ui and list from DB
        var newUiGroups = app.groups().getList();
//        newUiGroups.sort(compareById);
        var expectedNewList = new ArrayList<GroupData>();
        for (var newGroup : newGroups) {
            var id = newGroup.id();
            var name = newGroup.name();
            expectedNewList.add(new GroupData().withId(id).withName(name).withHeader("").withFooter(""));
        }
        Assertions.assertEquals(Set.copyOf(expectedNewList), Set.copyOf(newUiGroups));
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        var oldGroups = app.hbm().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();
        Assertions.assertEquals(newGroups, oldGroups);
    }
}
