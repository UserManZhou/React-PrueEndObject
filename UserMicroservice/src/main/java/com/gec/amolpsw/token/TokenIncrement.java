package com.gec.amolpsw.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gec.amolpsw.entity.UserInf;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TokenIncrement {

  public static String getToken(UserInf userInf){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        Map<String,Object> map = new HashMap<>();
        return JWT.create()
                          .withHeader(map)
                          .withClaim("playload", userInf.getId())
                          .withClaim("footer", userInf.getPassword())
                          .withExpiresAt(calendar.getTime())
                          .sign(Algorithm.HMAC256("!@#$%^&%^&*"));
    }


}
