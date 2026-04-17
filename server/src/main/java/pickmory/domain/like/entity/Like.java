package pickmory.domain.like.entity;

import jakarta.persistence.*;
import lombok.*;
import pickmory.domain.post.entity.Post;
import pickmory.domain.user.entity.User;

@Entity
@Table(name = "likes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "post_id"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
