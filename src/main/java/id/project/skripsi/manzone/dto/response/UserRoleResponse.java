package id.project.skripsi.manzone.dto.response;

import id.project.skripsi.manzone.dto.RoleDTO;

import java.util.List;

public class UserRoleResponse {
    List<RoleDTO> roleList;

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }
}
