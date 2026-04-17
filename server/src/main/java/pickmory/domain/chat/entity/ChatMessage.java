package pickmory.domain.chat.entity;

import jakarta.persistence.*;
import lombok.*;
import pickmory.domain.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime sentAt;

    @PrePersist
    protected void onSend() {
        this.sentAt = LocalDateTime.now();
    }
}
