package pickmory.domain.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.like.entity.Like;
import pickmory.domain.post.entity.Post;
import pickmory.domain.user.entity.User;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserAndPost(User user, Post post);
    Optional<Like> findByUserAndPost(User user, Post post);
    long countByPost(Post post);
}
