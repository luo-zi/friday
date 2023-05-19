package edu.friday.service;

import edu.friday.common.result.TableDataInfo;
import edu.friday.model.vo.SysUserVO;
import org.springframework.data.domain.Pageable;

public interface SysUserService {
    TableDataInfo selectUserList(SysUserVO user, Pageable page);

    boolean insert(SysUserVO user);

    String checkEmailUnique(SysUserVO user);

    String checkPhoneNumberUnique(SysUserVO user);




    String checkUserNameUnique(String username);
    boolean insertUser(SysUserVO sysUserVO);
}
