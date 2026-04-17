package pickmory.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickmory.domain.user.entity.UserAuth;
import pickmory.domain.user.entity.UserAuth.AuthProvider;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findByProviderAndProviderId(AuthProvider provider, String providerId);
    Optional<UserAuth> findByEmailAndProvider(String email, AuthProvider provider);
}
