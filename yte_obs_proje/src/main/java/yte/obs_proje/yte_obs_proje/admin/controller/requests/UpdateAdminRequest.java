package yte.obs_proje.yte_obs_proje.admin.controller.requests;

import yte.obs_proje.yte_obs_proje.admin.entity.Admin;

public record UpdateAdminRequest(
        String username,
        String password
) {
    public Admin toDomainEntity() {
        return new Admin(username, password);

    }

}
