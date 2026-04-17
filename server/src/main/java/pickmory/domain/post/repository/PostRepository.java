package pickmory.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.post.entity.Post;
import pickmory.domain.user.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserOrderByCreatedAtDesc(User user);
}
