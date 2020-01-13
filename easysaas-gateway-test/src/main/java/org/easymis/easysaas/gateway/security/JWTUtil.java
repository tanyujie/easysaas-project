package org.easymis.easysaas.gateway.security;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author ard333
 */
@Component
@Slf4j
public class JWTUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Value("${springbootwebfluxjjwt.jjwt.secret}")
	private String secret;
	
	@Value("${springbootwebfluxjjwt.jjwt.expiration}")
	private String expirationTime;
	/**
     * 从token中获取JWT中的负载
	 */
	public Claims getAllClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            throw e;
        }
        catch (Exception e) {
            log.info("JWT格式验证失败:{}",token);
        }
        return claims;
	}
    /**
     * 从token中获取登录用户名
     */
	public String getUsernameFromToken(String token) {

        String username;
        try {
            Claims claims = getAllClaimsFromToken(token);
            username =  claims.getSubject();
        }catch (ExpiredJwtException e){
            throw  e;
        }
        catch (Exception e) {
            username = null;
        }
        return username;
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	public String generateToken(Member user) {
		Map<String, Object> claims = new HashMap<>();
		//claims.put("role", user.getRoles());
		return doGenerateToken(claims, user.getPhoneNumber());
	}

	private String doGenerateToken(Map<String, Object> claims, String username) {
		Long expirationTimeLong = Long.parseLong(expirationTime); //in second
		
		final Date createdDate = new Date();
		final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);
		return Jwts.builder()
				//.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(createdDate)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(secret.getBytes()))
				.compact();
	}
	
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JWTUtil jwtUtil = new JWTUtil();
		
	}
}
