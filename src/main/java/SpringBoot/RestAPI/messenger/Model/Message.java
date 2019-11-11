package SpringBoot.RestAPI.messenger.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.Link;
//import org.springframework.hateoas.ResourceSupport;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@JacksonXmlRootElement
//public class Message extends ResourceSupport {
public class Message {

    private long id;
    private String message;
    private LocalDate date;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();
    private String content;
    private Link link;

    @JsonCreator
    public Message(@JsonProperty("content") String content){
        this.content = content;
    }

    public Message(long id, String message, String author) {
        LocalDate now = LocalDate.now();

        this.id = id;
        this.message = message;
        this.author = author;
//        this.date = now;
    }

    @Transient
    public Map<Long, Comment> getComments() {
        return comments;
    }

}
