package SpringBoot.RestAPI.messenger.Model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@JacksonXmlRootElement
public class Profile {

    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private LocalDate created;

    public Profile(long id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
