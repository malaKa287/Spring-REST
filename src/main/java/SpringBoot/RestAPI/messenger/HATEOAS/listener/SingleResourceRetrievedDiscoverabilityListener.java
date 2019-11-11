package SpringBoot.RestAPI.messenger.HATEOAS.listener;

import SpringBoot.RestAPI.messenger.HATEOAS.event.SingleResourceRetrievedEvent;
import SpringBoot.RestAPI.messenger.HATEOAS.resource.LinkUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@Component
public class SingleResourceRetrievedDiscoverabilityListener implements ApplicationListener<SingleResourceRetrievedEvent> {

    @Override
    public void onApplicationEvent(SingleResourceRetrievedEvent resourceRetrievedEvent) {
        HttpServletResponse response = resourceRetrievedEvent.getResponse();

        addLinkHeaderOnSingleResource(response);
    }

    void addLinkHeaderOnSingleResource(HttpServletResponse response){
        String requestURL = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .toUri()
                .toASCIIString();

//        int positionOfLastSlash = requestURL.lastIndexOf("/");
//        String uriForResourceCreation = requestURL.substring(0, positionOfLastSlash);

//        String linkHeaderValue = LinkUtil.createLinkHeader(uriForResourceCreation, LinkUtil.REL_COLLECTION);
        String linkHeaderValue = LinkUtil.createLinkHeader(requestURL, LinkUtil.REL_COLLECTION);
        response.addHeader(HttpHeaders.LINK,linkHeaderValue);
    }
}
