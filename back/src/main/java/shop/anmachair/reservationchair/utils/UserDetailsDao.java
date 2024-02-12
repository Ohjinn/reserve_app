package shop.anmachair.reservationchair.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.Optional;

@Component
public class UserDetailsDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDetailsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<UserDetails> findByUsername(String username) {
        String query = "SELECT user_id FROM user WHERE user_name=?";

        return jdbcTemplate.query(query, resultSet -> {
            if (!resultSet.next()) {
                return Optional.empty();
            }

            String id = resultSet.getString("id");

            UserDetails userDetails = User.withUsername(id)
                    .build();

            return Optional.of(userDetails);
        }, username);
    }

    public void addAccessToken(String userId, String accessToken) {
        jdbcTemplate.update("""
                INSERT INTO access_token (token, user_id)
                VALUES (?, ?)
                """,
                accessToken, userId);
    }

    public Optional<UserDetails> findByAccessToken(String accessToken) {
        String query = """
            SELECT user.user_id
            FROM user
            JOIN access_token On access_token.user_id=user.user_id
            WHERE access_token.token=?
            """;

        return jdbcTemplate.query(query, resultSet -> {
            if (!resultSet.next()) {
                return Optional.empty();
            }

            String id = resultSet.getString("id");
            String role = resultSet.getString("role");

            UserDetails userDetails = User.withUsername(id)
                    .password(accessToken)
                    .authorities(role)
                    .build();

            return Optional.of(userDetails);
        }, accessToken);
    }

    public void removeAccessToken(String accessToken) {
        jdbcTemplate.update("""
                DELETE FROM access_token WHERE token=?
                """,
                accessToken);
    }

    public boolean existsByUsername(String username) {
        String query = "SELECT user_id FROM user WHERE user_name=?";

        return Boolean.TRUE.equals(
                jdbcTemplate.query(query, ResultSet::next, username));
    }

    public void addUser(String id, String username) {
        jdbcTemplate.update("""
                INSERT INTO user (user_id, user_name)
                VALUES (?, ?)
                """,
                id, username
        );
    }
}