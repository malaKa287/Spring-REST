package SpringBoot.RestAPI.messenger.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
//import static org.sfw.hateoas.server.mvc.WebMvcLinkBuilder.*;

import SpringBoot.RestAPI.messenger.Exception.DataNotFoundException;
import SpringBoot.RestAPI.messenger.HATEOAS.event.ResourceCreatedEvent;
import SpringBoot.RestAPI.messenger.HATEOAS.event.SingleResourceRetrievedEvent;
import SpringBoot.RestAPI.messenger.Model.Message;
import SpringBoot.RestAPI.messenger.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.*;

//@Controller
@RequestMapping("/messenger")
@RestController()
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

//    @Autowired
//    @Qualifier("comment")
//    CommentController commentController;

    //        @GetMapping(value = "/messages", produces = { "application/xml", "text/xml" }, consumes = MediaType.ALL_VALUE)
    @GetMapping(value = "/messages")
    public List<Message> getMessages(@RequestParam(name = "year", required = false) Integer year,
                                     @RequestParam(name = "start", required = false) Integer start,
                                     @RequestParam(name = "size", required = false) Integer size) {
        if (year != null) {
            return messageService.getAllMessagesForYear(year);
        }
        if (size != null && start != null) {
            return messageService.getAllMessagesPaginated(start, size);
        }
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable long id, HttpServletResponse response, HttpServletRequest request) {
        if (messageService.getMessage(id) == null) {
            throw new DataNotFoundException("no such message");
        }
        Message message = messageService.getMessage(id);

        eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, response));

        String requestURI = request.getRequestURI();
        Link link = linkTo(Message.class).slash(requestURI).withSelfRel();

        System.out.println(link);

        return messageService.getMessage(id);
    }


    @PostMapping("/messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message message, HttpServletRequest request, HttpServletResponse response) {
        Message newMessage = messageService.addMessage(message);
        String newId = String.valueOf(message.getId());
        String requestURI = request.getRequestURI().concat("/" + newId);

        long idOfCreatedResource = Integer.valueOf(newId);
        eventPublisher.publishEvent(new ResourceCreatedEvent(this, response, idOfCreatedResource));

//        Message messageLink = new Message("cooontent");
//        message.add(linkTo(methodOn(MessageController.class)).withSelfRel());

        Link link = linkTo(Message.class).slash(requestURI).withSelfRel();
//        Link link = linkTo(methodOn(MessageController.class)).withSelfRel();
        newMessage.setLink(link);

        System.out.println("link: " + link);

        return ResponseEntity.created(URI.create(requestURI))
                .body(newMessage);
    }

    @PutMapping("/messages/{id}")
    public Message updateMessage(@RequestBody Message message, @PathVariable long id) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/messages/{id}")
    public Message removeMessage(@PathVariable long id) {
        return messageService.removeMessage(id);
    }

//    @RequestMapping("/{messageId}/comments")
//    public CommentController getCommentResource() {
////        return new CommentController();
//        return commentController;
//    }
}
