package shop.anmachair.reservationchair.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shop.anmachair.reservationchair.repositories.UserRepository;

import java.util.Map;

@Service
public class KakaoLoginService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public KakaoLoginService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    private Map<String, Object> getAttributes(String accessToken) {
        //RestTemplate를 사용하여 HTTP 요청을 실행
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Map> response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.GET, entity, Map.class);

        Map<String, Object> attributes = response.getBody();
        if (attributes == null || !attributes.containsKey("id")) {
            throw new IllegalArgumentException(String.format("카카오 API RestTemplate 에러 (%s)", attributes));
        }
        return attributes;
    }

    private static void checkTokenIsNull(String idToken) {
        if (idToken == null || idToken.isEmpty()) {
            throw new IllegalArgumentException(String.format("토큰이 존재하지 않습니다. (%s)", idToken));
        }
    }
}
