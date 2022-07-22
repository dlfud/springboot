package com.mysite.sbb.user.service;

import com.mysite.sbb.user.dao.SiteUserRepository;
import com.mysite.sbb.user.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String userName, String email, String password){
        SiteUser siteUser = new SiteUser();
        siteUser.setUserName(userName);
        siteUser.setEmail(email);
        siteUser.setPassword(password);
        this.siteUserRepository.save(siteUser);
        return siteUser;
    }
}
