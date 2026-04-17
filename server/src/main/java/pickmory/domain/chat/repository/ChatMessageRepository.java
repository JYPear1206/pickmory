package pickmory.domain.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.chat.entity.ChatMessage;
import pickmory.domain.chat.entity.ChatRoom;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoomOrderBySentAtAsc(ChatRoom chatRoom);
}
