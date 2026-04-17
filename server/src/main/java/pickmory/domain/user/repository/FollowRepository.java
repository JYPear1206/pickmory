package pickmory.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.user.entity.Follow;
import pickmory.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    boolean existsByFollowerAndFollowing(User follower, User following);
    Optional<Follow> findByFollowerAndFollowing(User follower, User following);
    List<Follow> findByFollower(User follower);
    List<Follow> findByFollowing(User following);
}
