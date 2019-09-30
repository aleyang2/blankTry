import Entity.People;

public interface PlayGround {

    void init(People p1, String s1, String s2);

    void doActivity(String activity);

    void destroy();
}
