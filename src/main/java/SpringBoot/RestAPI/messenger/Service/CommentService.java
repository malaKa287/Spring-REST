package SpringBoot.RestAPI.messenger.Service;

import SpringBoot.RestAPI.messenger.DAO.DatabaseClass;
import SpringBoot.RestAPI.messenger.Model.Comment;
import SpringBoot.RestAPI.messenger.Model.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        LocalDate date = LocalDate.now();

        comment.setId(comments.size() + 1);
        comment.setDate(date);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0){
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment deleteComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
