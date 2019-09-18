import Entity.Group;
import Entity.People;

import java.util.List;

public interface GroupUp {

    Group mergeGroupMembers(List<People> l1, String name);

    // int countGroupMembers(String groupName);
}
