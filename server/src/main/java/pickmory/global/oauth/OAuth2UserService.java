package pickmory.global.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pickmory.domain.user.entity.User;
import pickmory.domain.user.entity.UserAuth;
import pickmory.domain.user.entity.UserAuth.AuthProvider;
import pickmory.domain.user.repository.UserAuthRepository;
import pickmory.domain.user.repository.UserRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final UserAuthRepository userAuthRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();
        String providerId = (String) attributes.get("sub");
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        UserAuth userAuth = userAuthRepository
                .findByProviderAndProviderId(AuthProvider.GOOGLE, providerId)
                .orElseGet(() -> createUser(providerId, email, name));

        return new OAuth2UserPrincipal(userAuth.getUser(), attributes);
    }

    private UserAuth createUser(String providerId, String email, String name) {
        User user = userRepository.save(User.builder()
                .username(generateUsername(email))
                .build());

        return userAuthRepository.save(UserAuth.builder()
                .user(user)
                .provider(AuthProvider.GOOGLE)
                .providerId(providerId)
                .email(email)
                .build());
    }

    private String generateUsername(String email) {
        String base = email.split("@")[0];
        if (!userRepository.existsByUsername(base)) return base;
        return base + "_" + System.currentTimeMillis();
    }
}
