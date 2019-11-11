package SpringBoot.RestAPI.messenger.HATEOAS.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import javax.servlet.http.HttpServletResponse;

@Getter
public class ResourceCreatedEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private long idOfNewResource;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, long idOfNewResource) {
        super(source);

        this.response = response;
        this.idOfNewResource = idOfNewResource;
    }


}
