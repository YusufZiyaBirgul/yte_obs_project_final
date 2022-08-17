package yte.obs_proje.yte_obs_proje.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.obs_proje.yte_obs_proje.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
