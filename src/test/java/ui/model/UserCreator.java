package ui.model;

import org.apache.commons.lang3.RandomStringUtils;

public class UserCreator {
    public static final String USER_NAME = "selenaspotify99@gmail.com";
    public static final String PASSWORD = "WZv5tz??sk7UPc";

    public static User createCorrectUser() {
        return new User(USER_NAME, PASSWORD);
    }

    public static User createRandomUser() {
        return new User(RandomStringUtils.randomAlphanumeric(8), RandomStringUtils.randomAlphabetic(8));
    }
}
