package com.project.diplomaed.repository;

import com.project.diplomaed.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rOlguin
 */
public interface UserRepository extends JpaRepository<User,Long>{
    //    @Query("select m from Message m where m.user.groupUsers.group =:groupId")
//    List<Message> findAllMessageByUserId(@Param("groupId") Role groupId);
}
