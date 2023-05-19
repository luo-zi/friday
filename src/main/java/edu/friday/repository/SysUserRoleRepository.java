package edu.friday.repository;


import edu.friday.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Long> {
}
