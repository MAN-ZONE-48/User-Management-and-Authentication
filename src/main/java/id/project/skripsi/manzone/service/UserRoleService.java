package id.project.skripsi.manzone.service;

import id.project.skripsi.manzone.dto.response.UserRoleResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    UserRoleResponse getUserRole();
}
