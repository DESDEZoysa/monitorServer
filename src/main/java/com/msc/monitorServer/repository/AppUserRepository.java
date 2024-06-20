package com.msc.monitorServer.repository;

import com.msc.monitorServer.model.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserEntity,Integer> {

    Optional<AppUserEntity> findByUsername(String userName);
}
