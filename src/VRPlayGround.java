import Entity.Device;
import Entity.Location;
import Entity.People;

import java.util.Collection;
import java.util.HashSet;
import java.util.*;

public class VRPlayGround implements PlayGround {

    private Device device;
    private Location location;
    private final Collection<String> allowedAccess;

    private final String DEFAULT_DEVICE = "VR Device";
    private final String DEFAULT_ADDRESS = "771 Alder DRIVE";

    public VRPlayGround() {
        this.allowedAccess = new HashSet<>();
    }


    @Override
    public void init(People p1, String s1, String s2) {
        if (s1 == null || s2 == null) {
            device = new Device(DEFAULT_DEVICE);
            location = new Location(DEFAULT_ADDRESS);
        } else {
            device = new Device(s1);
            location = new Location(s2);
        }
        if (p1.getAge() > 18) {
            // System.out.println("You are less than 18");
            this.allowedAccess.clear();
            List<String> child1Info = new LinkedList<>();
            child1Info.add(p1.getName());
            child1Info.add(p1.getIncomeType());
            this.allowedAccess.addAll(child1Info);
        }
    }

    @Override
    public void doActivity(String activity) {
        if (allowedAccess.size() > 0) {
            System.out.println("Allowed Access granted");
        }
        System.out.println("We are doing" + activity);
        System.out.println(allowedAccess.size());
    }

    @Override
    public void destroy() {
        // nothing for now.
    }

    public String getDevice() {
        return device.getType();
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
