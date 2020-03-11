package id.project.skripsi.manzone.dao;

import id.project.skripsi.manzone.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole,String> {

    UserRole findUserRoleByUserRoleName(String userRoleName);

}
