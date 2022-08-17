package yte.obs_proje.yte_obs_proje.assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;

import java.util.Optional;

public interface AssistantRepository extends JpaRepository<Assistant, Long> {

    Optional<Assistant> findAssistantByName(String Name);
}
