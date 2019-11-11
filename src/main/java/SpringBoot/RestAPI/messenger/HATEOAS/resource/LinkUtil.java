package SpringBoot.RestAPI.messenger.HATEOAS.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkUtil {

    public static final String REL_COLLECTION = "collection";
    public static final String REL_NEXT = "next";
    public static final String REL_PREV = "prev";
    public static final String REL_FIRST = "first";
    public static final String REL_LAST = "last";

    private String link;
    private String rel;

    private LinkUtil() {
        throw new AssertionError();
    }


    public static String createLinkHeader(String uri, String rel){
        return "<" + uri + ">; rel=\"" + rel + "\"";
    }
}
