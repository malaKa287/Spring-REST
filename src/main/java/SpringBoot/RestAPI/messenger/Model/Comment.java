package SpringBoot.RestAPI.messenger.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
//@Service
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue
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
