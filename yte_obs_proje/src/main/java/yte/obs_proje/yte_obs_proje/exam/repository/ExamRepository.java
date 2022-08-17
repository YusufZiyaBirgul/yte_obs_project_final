package yte.obs_proje.yte_obs_proje.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.obs_proje.yte_obs_proje.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
