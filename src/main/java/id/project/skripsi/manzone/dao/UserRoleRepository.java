package id.project.skripsi.manzone.dao;

import com.java.common.lib.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole,String> {

    @Query(value = "SELECT * FROM user_role",nativeQuery = true)
    List<UserRole> getAllUserRole();

    UserRole findUserRoleByUserRoleName(String userRoleName);

}
