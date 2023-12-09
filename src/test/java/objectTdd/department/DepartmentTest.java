package objectTdd.department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DepartmentTest {

    private List<User> users;

    @BeforeEach
    void setUp() {
        users = mock(List.class);
    }

    @Test
    void testIsExistMember() {
        Department department = new Department("Development", users);
        User user = new User("kim");

        department.addMember(user);

        verify(users).add(user);
    }

}