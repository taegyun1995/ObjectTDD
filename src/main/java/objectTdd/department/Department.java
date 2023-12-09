package objectTdd.department;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<User> members;

    public Department(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public Department(String name, List<User> members) {
        this.name = name;
        this.members = members;
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public boolean isExistMember(User user) {
        if (members == null) {
            return false;
        } else {
            return members.contains(user);
        }
    }

}