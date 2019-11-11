package SpringBoot.RestAPI.messenger.HATEOAS.listener;


import SpringBoot.RestAPI.messenger.HATEOAS.event.ResourceCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class ResourceCreatedDiscoverabilityListener implements ApplicationListener<ResourceCreatedEvent> {

    @Override
    public void onApplicationEvent(ResourceCreatedEvent resourceCreatedEvent) {

        HttpServletResponse response = resourceCreatedEvent.getResponse();
        long idOfNewResource = resourceCreatedEvent.getIdOfNewResource();

        addLinkHeader(response, idOfNewResource);
    }

    void addLinkHeader(HttpServletResponse response, long idOfNewResource){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{/idOfNewResource}")
                .buildAndExpand(idOfNewResource)
                .toUri();
        response.setHeader(HttpHeaders.LOCATION, uri.toASCIIString());
    }
}
