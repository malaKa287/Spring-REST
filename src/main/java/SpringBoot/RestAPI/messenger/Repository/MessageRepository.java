package SpringBoot.RestAPI.messenger.Repository;

import SpringBoot.RestAPI.messenger.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    List<Message> findAll();

    @Override
    <S extends Message> S save(S s);

    @Override
    Message getOne(Long messageId);

    @Override
    void deleteById(Long messageId);
}
