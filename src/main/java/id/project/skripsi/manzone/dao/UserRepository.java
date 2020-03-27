package id.project.skripsi.manzone.dao;

import id.project.skripsi.manzone.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserData,String> {

    UserData findUserDataByUserName(String userName);

    @Query(value = "SELECT * FROM user_data",nativeQuery = true)
    List<UserData> getAllUser();

}
