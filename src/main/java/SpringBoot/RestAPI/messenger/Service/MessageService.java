package SpringBoot.RestAPI.messenger.Service;

import SpringBoot.RestAPI.messenger.Model.Message;
import SpringBoot.RestAPI.messenger.DAO.DatabaseClass;
import SpringBoot.RestAPI.messenger.Repository.MessageRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageService {

    @Autowired
    MessageRepository repository;

    public MessageService(){
        messages.put(1L, new Message(1L, "message", "author"));
    }

    @Getter
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Message> getAllMessages(){
        System.out.println(repository.findAll());
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year){
        return messages.values().stream()
                .filter(message -> message.getDate().getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Message> getAllMessagesPaginated(int start, int size){
       List<Message> messages = new ArrayList<Message>(getAllMessages());
        if ((start + size) > messages.size()){
            return new ArrayList<Message>();
        }
        return messages.subList(start, size);
    }

    public Message getMessage(long id){
        System.out.println(repository.getOne(id));
        return messages.get(id);
    }

    public Message addMessage(Message message){
        LocalDate date = LocalDate.now();

        message.setId(messages.size() + 1);
        message.setDate(date);
        messages.put(message.getId(), message);

        repository.save(message);
        return message;
    }

    public Message updateMessage(Message message){
        if (message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);

        repository.save(message);
        return message;
    }

    public Message removeMessage(long id){
        repository.deleteById(id);
        return messages.remove(id);
    }

}
