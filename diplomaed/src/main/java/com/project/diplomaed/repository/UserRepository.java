package com.project.diplomaed.repository;

import com.project.diplomaed.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author rOlguin
 */
public interface UserRepository extends JpaRepository<User,Long>{
    //    @Query("select m from Message m where m.user.groupUsers.group =:groupId")
//    List<Message> findAllMessageByUserId(@Param("groupId") Role groupId);
    //@Query("select u from User u inner join **u.roleAssignments** ar where ar.user.id = :idArea")
    @Query("SELECT p FROM User p WHERE p.userName = :userName AND p.password =:password")
    User findUserByUserNameByPassword(@Param("userName") String userName, @Param("password") String password);
}
