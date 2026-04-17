package pickmory.domain.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.chat.entity.ChatRoom;
import pickmory.domain.chat.entity.ChatRoomMember;
import pickmory.domain.user.entity.User;

import java.util.List;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long> {
    List<ChatRoomMember> findByChatRoom(ChatRoom chatRoom);
    List<ChatRoomMember> findByUser(User user);
}
