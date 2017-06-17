package com.ashin.JWT;

import com.ashin.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.StringTokenizer;

/**
 * Created by trile on 6/11/2017.
 */
public class JWTEncryptDecrypt {
    private static Key key = MacProvider.generateKey();
    public static String encryptJWT(User user){

        String token = Jwts.builder()
                .setSubject(user.toString())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return token;
    }
    public static User decrypt(String token){
        StringTokenizer stk;
        String result = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        stk = new StringTokenizer(result, "\t");
        String userName = stk.nextToken();
        String password = stk.nextToken();
        User user = new User(userName,password);
        return user;
    }
    public static void main(String[] args) {
//        User user = new User("trile28", "anhtri287");
//
//        String token = JWTEncryptDecrypt.encryptJWT(user);
//
////        System.out.println(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject());
//        //System.out.println(decrypt(token));
//        User u = JWTEncryptDecrypt.decrypt(token);
//        System.out.println(u.toString());
    }

}
