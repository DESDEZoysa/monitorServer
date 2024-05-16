package com.msc.monitorServer.repository;

import com.msc.monitorServer.model.entity.ServerMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServerMessageRepository extends JpaRepository<ServerMessageEntity, Integer> {
    List<ServerMessageEntity> findAllByUpdatedChoicesTextIsNull();
    List<ServerMessageEntity> findAllByUpdatedChoicesText(String updatedChoicesText);
    List<ServerMessageEntity> findAllByInitialChoicesTextAndUpdatedChoicesTextIsNull(String updatedChoicesText);
    List<ServerMessageEntity> findAllByInitialChoicesTextOrUpdatedChoicesText(String initialChoicesText,String updatedChoicesText);
    List<ServerMessageEntity> findAllByInitialChoicesTextAndUpdatedChoicesText(String initialChoicesText,String updatedChoicesText);
}
