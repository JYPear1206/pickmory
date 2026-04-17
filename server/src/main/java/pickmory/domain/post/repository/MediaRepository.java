package pickmory.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.post.entity.Media;
import pickmory.domain.post.entity.Post;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByPostOrderByOrderIndexAsc(Post post);
}
