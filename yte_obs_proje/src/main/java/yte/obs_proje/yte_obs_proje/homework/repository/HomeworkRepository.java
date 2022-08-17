package yte.obs_proje.yte_obs_proje.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.obs_proje.yte_obs_proje.homework.entity.Homework;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
