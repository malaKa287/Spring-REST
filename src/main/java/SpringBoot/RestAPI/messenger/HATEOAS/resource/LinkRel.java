package SpringBoot.RestAPI.messenger.HATEOAS.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LinkRel {

    private String link;
    private String rel;
}
