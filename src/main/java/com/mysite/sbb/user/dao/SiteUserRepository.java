package com.mysite.sbb.user.dao;

import com.mysite.sbb.user.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {

    Optional<SiteUser> findByUsername(String userName);
}
