package SpringBoot.RestAPI.messenger.Service;

import SpringBoot.RestAPI.messenger.Model.Profile;
import SpringBoot.RestAPI.messenger.DAO.DatabaseClass;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProfileService {

    public ProfileService(){
        profiles.put("profile name", new Profile(1L, "profileName", "firstName", "lastName"));
    }

    @Getter
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        LocalDate date = LocalDate.now();

        profile.setId(profiles.size() + 1);
        profile.setCreated(date);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if (profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
