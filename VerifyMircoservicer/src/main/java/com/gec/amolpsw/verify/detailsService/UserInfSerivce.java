package com.gec.amolpsw.verify.detailsService;

import com.gec.amolpsw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfSerivce implements UserDetailsService {

    @Autowired(required = false)
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin");

        //UserInf userbyName = userService.findUserbyName(username);
//        System.out.println("userbyName = " + userbyName.toString());
//        if (userbyName == null){
//            throw new UsernameNotFoundException("未找到该账户");
//        }
//        System.out.println("-----------------------");
//        return new User(userbyName.getLoginname(), new BCryptPasswordEncoder().encode(userbyName.getPassword()), grantedAuthorities);
        return null;
    }
}
