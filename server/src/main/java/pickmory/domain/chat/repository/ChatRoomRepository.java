package pickmory.domain.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.chat.entity.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
