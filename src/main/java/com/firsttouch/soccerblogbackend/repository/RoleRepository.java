package com.firsttouch.soccerblogbackend.repository;

import com.firsttouch.soccerblogbackend.entity.ERole;
import com.firsttouch.soccerblogbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
