package edu.friday.repository;

import edu.friday.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    final String JOIN_ROLE = " left join sys_user_role ur on ur.role_id=r.role_id ";
    final String JOIN_USER = " left join sys_user u on u.user_id=ur.user_id ";

    @Query(value = "select r.role_id from sys_role r" + JOIN_ROLE + JOIN_USER
            + "where r.del_flag='0' and u.user_id=:userId", nativeQuery = true)
    List<SysRole> selectRoleIdsByUserId(@Param("userId") Long userId);
}
