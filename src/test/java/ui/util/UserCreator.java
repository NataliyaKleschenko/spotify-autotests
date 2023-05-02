package ui.util;
import org.apache.commons.lang3.RandomStringUtils;
import ui.model.User;
public class UserCreator {
    public static final String USER_NAME = UserProperties.getProperty("username");
    public static final String PASSWORD = UserProperties.getProperty("password");

    public static User createCorrectUser() {
        return new User(USER_NAME, PASSWORD);
    }

    public static User createRandomUser() {
        return new User(RandomStringUtils.randomAlphanumeric(9), RandomStringUtils.randomAlphabetic(9));
    }
}
