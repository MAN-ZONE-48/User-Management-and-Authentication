package id.project.skripsi.manzone.dao;

import id.project.skripsi.manzone.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserData,String> {

    @Query(value = "SELECT * FROM user_data WHERE userName = :userName", nativeQuery = true)
    UserData findUserDataByUserName(String userName);

}
