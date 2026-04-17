package pickmory.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "media")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false, length = 500)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private MediaType mediaType;

    @Column(nullable = false)
    private Integer orderIndex;

    public enum MediaType {
        IMAGE, VIDEO
    }
}
