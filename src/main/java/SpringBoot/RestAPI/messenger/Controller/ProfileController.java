package SpringBoot.RestAPI.messenger.Controller;

import SpringBoot.RestAPI.messenger.Model.Profile;
import SpringBoot.RestAPI.messenger.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@RequestMapping("profiles")
@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profiles")
    public @ResponseBody
    List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/profiles/{profileName}")
    public @ResponseBody
    Profile getProfile(@PathVariable String profileName){
        return profileService.getProfile(profileName);
    }

    @PostMapping("/profiles")
    public @ResponseBody
    Profile addProfile(@RequestBody Profile profile){
        return profileService.addProfile(profile);
    }

    @PutMapping("/profiles/{profileName}")
    public @ResponseBody
    Profile updateProfile(@RequestBody Profile profile, @PathVariable String profileName){
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DeleteMapping("/profiles/{profileName}")
    public @ResponseBody
    Profile removeProfile(@PathVariable String profileName){
        return profileService.removeProfile(profileName);
    }
}
