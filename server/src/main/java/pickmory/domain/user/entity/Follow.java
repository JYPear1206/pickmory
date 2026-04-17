package pickmory.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "follow",
        uniqueConstraints = @UniqueConstraint(columnNames = {"follower_id", "following_id"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id", nullable = false)
    private User following;
}
