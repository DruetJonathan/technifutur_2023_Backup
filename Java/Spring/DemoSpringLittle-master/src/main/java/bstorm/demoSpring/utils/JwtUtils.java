package bstorm.demoSpring.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtils {

    @Value("${jwt.duration}")
    private Long duration;

    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Long id, String role, String username) {

        return Jwts.builder()
                .claim("id", id)
                .claim("role", role)
                .claim("username", username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Boolean isValid(String token) {
        Claims claims = getClaims(token);
        Date now = new Date();
        return claims.get("role", String.class) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }

    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public Long getId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    public String getUsername(String token) {
        return getClaims(token).get("username", String.class);
    }
}
