package SpringBoot.RestAPI.messenger.Controller;

import SpringBoot.RestAPI.messenger.HATEOAS.resource.LinkUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void adminRoot(final HttpServletRequest request, final HttpServletResponse response){
        String rootUri = request.getRequestURI().toString();

        URI fooUri = new UriTemplate("{rootUri}{resource}").expand(rootUri, "foos");
        String linkToFoos = LinkUtil.createLinkHeader(fooUri.toASCIIString(), LinkUtil.REL_COLLECTION);
        response.addHeader(HttpHeaders.LINK, linkToFoos);
    }
}
