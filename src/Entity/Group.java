package Entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final List<People> groupMembers;
    String groupName;
    int groupSize;

    public Group() {
        this.groupMembers = new ArrayList<>();
    }

    public List<People> getGroupMembers() {
        return groupMembers;
    }

//    public void setGroupMembers(List<People> groupMembers) {
//        this.groupMembers = groupMembers;
//    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public static final People DEFAULT_PEOPLE = new People("Trump", 58, 999999, "inf");
}
