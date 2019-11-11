package SpringBoot.RestAPI.messenger.Controller;

import SpringBoot.RestAPI.messenger.Model.Comment;
import SpringBoot.RestAPI.messenger.Service.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RequestMapping("/messenger/messages/{messageId}")
//@RestController("comment")
@RestController
//@NoArgsConstructor
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAllComments(@PathVariable("messageId") long messageId){
        return commentService.getAllComments(messageId);
    }

    @GetMapping("/comments/{commentId}")
    public Comment getComment(@PathVariable("messageId") long messageId, @PathVariable("commentId") long commentId){
        return commentService.getComment(messageId, commentId);
    }

    @PostMapping("/comments")
    public Comment addComment(@PathVariable("messageId") long messageId, @RequestBody Comment comment){
        return commentService.addComment(messageId, comment);
    }

    @PutMapping("/comments")
    public Comment updateComment(@PathVariable("messageId") long messageId, @RequestBody Comment comment){
        return commentService.updateComment(messageId, comment);
    }

    @DeleteMapping("/comments/{commentId}")
    public Comment removeComment(@PathVariable("messageId") long messageId, @PathVariable("commentId") long commentId){
        return commentService.deleteComment(messageId, commentId);
    }
}
