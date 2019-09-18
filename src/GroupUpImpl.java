import Entity.Group;
import Entity.People;

import java.util.*;

public class GroupUpImpl implements GroupUp {

    private final Collection<String> allowedOrigins;

    public GroupUpImpl() {
        this.allowedOrigins = new HashSet<>();
    }

    @Override
    public Group mergeGroupMembers(List<People> l1, String name) {
        Group g = new Group();
        for (People c : l1) {
            g.getGroupMembers().add(c);
        }
        g.setGroupName(name);
        g.setGroupSize(l1.size());
        return g;
    }

    public Group mergeGroupMembers(String s) {
        List<People> l = new LinkedList<>();
        Group g = new Group();
        return g;
    }

    public Collection<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void modifyAllowedOrigins(String allowedOrigin) {
        if (allowedOrigin != null) {
            if (allowedOrigin.trim().equals("*")) {
                // this.anyOriginAllowed = true;
                System.out.println("Everything comes through");
            } else {
                // this.anyOriginAllowed = false;
                Set<String> setAllowedOrigins = parseStringToSet(allowedOrigin);
                this.allowedOrigins.clear();
                this.allowedOrigins.addAll(setAllowedOrigins);
            }
        }
    }

    private Set<String> parseStringToSet(final String data) {
        String[] splits;

        if (data != null && data.length() > 0) {
            splits = data.split(",");
        } else {
            splits = new String[] {};
        }

        Set<String> set = new HashSet<String>();
        if (splits.length > 0) {
            for (String split : splits) {
                set.add(split.trim());
            }
        }

        return set;
    }

    public static final String DEFAULT_ALLOWED_ORIGIN = "*";
}
