package SpringBoot.RestAPI.messenger.HATEOAS.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class SingleResourceRetrievedEvent extends ApplicationEvent {

    private HttpServletResponse response;

    public SingleResourceRetrievedEvent(Object source, HttpServletResponse response) {
        super(source);

        this.response = response;
    }
}
