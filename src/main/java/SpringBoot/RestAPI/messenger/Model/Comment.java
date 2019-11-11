package SpringBoot.RestAPI.messenger.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    private long id;
    private String message;
    private LocalDate date;
    private String author;

    public Comment(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }
}
