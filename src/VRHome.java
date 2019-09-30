import Entity.People;

public class VRHome extends VRPlayGround {

    Integer homesize;

    public VRHome() {
        this.homesize = 0;
    }

    @Override
    public void doActivity(String activity) {
        System.out.println("This is a VRHome");
    }

    public void doActivity(String activity, People p1) {
        homesize++;
        System.out.println("There is a person there");
        System.out.println(homesize);
    }
}
