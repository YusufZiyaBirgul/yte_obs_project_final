package yte.obs_proje.yte_obs_proje.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
