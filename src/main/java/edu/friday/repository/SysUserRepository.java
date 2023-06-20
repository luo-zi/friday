package edu.friday.repository;

import edu.friday.model.SysUser;
import edu.friday.repository.custom.SysUserCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long>, SysUserCustomRepository {

    @Transactional
    @Modifying
    @Query(value = "update sys_user set del_flag='2' where user_id in :userIds", nativeQuery = true)
    int deleteUserByIds(@Param("userIds") long[] userIds);

    @Transactional
    @Modifying
    @Query(value = "delete from sys_user_role where user_id=:userId", nativeQuery = true)
    void deleteUserRoleByUserId(@Param("userId") Long userId);
//    JSON
    /*
{
  "user_id": 2,
  "user_name": "zzjw",
  "nick_name": "",
  "user_type": "00",
  "email": "",
  "phonenumber": "",
  "sex": "0",
  "avatar": "",
  "password": "",
  "status": "0",
  "del_flag": "0",
  "login_ip": "",
  "login_date": "2023-06-20T08:06:01",
  "create_by": "",
  "create_time": "2023-06-20T08:06:01",
  "update_by": "",
  "update_time": "2023-06-20T08:06:01",
  "remark": ""
}
    * */
}

