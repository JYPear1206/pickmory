package pickmory.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.comment.entity.Comment;
import pickmory.domain.post.entity.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostOrderByCreatedAtAsc(Post post);
}
