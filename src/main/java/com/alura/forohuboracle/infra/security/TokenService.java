package com.alura.forohuboracle.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alura.forohuboracle.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class TokenService {
    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            token = JWT.create()
                .withIssuer("forohub")
                .withSubject(usuario.getCorreo())
                .withClaim("id", usuario.getId())
                .withExpiresAt(generarFechaExpiracion())
                .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
        return token;
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
    }

    @SuppressWarnings("null")
    public String getSubject(String token){
        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT decodedJWT = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma  
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("forohub")
                .build();
            decodedJWT = verifier.verify(token);
            
        } catch (JWTVerificationException exception){
            exception.toString();
        }
        if (decodedJWT.getSubject() == null) {
            throw new RuntimeException("verifier invalido");
        }else{
            return decodedJWT.getSubject();
        }
        
    }
}
