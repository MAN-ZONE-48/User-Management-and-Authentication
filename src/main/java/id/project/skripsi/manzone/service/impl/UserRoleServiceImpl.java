package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.dao.UserRoleRepository;
import id.project.skripsi.manzone.domain.UserRole;
import id.project.skripsi.manzone.dto.RoleDTO;
import id.project.skripsi.manzone.dto.response.UserRoleResponse;
import id.project.skripsi.manzone.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleResponse getUserRole() {
        List<UserRole> userRoleList =  userRoleRepository.getAllUserRole();
        UserRoleResponse roleResponse = new UserRoleResponse();
        List<RoleDTO> roleDTOList = new ArrayList<>();

        for(int counter = 0; counter<userRoleList.size();counter++){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setUserRoleId(userRoleList.get(counter).getId());
            roleDTO.setUserRoleName(userRoleList.get(counter).getUserRoleName());
            roleDTOList.add(roleDTO);
        }
        roleResponse.setRoleList(roleDTOList);
        return roleResponse;
    }
}
