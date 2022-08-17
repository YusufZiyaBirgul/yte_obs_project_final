package yte.obs_proje.yte_obs_proje.admin.controller.responses;

import yte.obs_proje.yte_obs_proje.admin.entity.Admin;

public record AdminQueryModel(
        Long id,
        String username,
        String password
) {
    public AdminQueryModel(Admin admin) {
        this(
                admin.getId(),
                admin.getUsername(),
                admin.getPassword()

        );
    }
}
