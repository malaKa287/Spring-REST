package SpringBoot.RestAPI.messenger.DAO;

import SpringBoot.RestAPI.messenger.Model.Message;
import SpringBoot.RestAPI.messenger.Model.Profile;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    @Getter
    private static Map<Long, Message> messages = new HashMap<>();
    @Getter
    private static Map<String, Profile> profiles = new HashMap<>();

}
