package yte.obs_proje.yte_obs_proje.assistant.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.obs_proje.yte_obs_proje.academician.entity.Academician;
import yte.obs_proje.yte_obs_proje.academician.service.AcademicianService;
import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;
import yte.obs_proje.yte_obs_proje.assistant.repository.AssistantRepository;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.common.response.ResponseType;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistantService {



    private final AssistantRepository assistantRepository;
    private final AcademicianService academicianService;


    public MessageResponse addAssistant(Assistant assistant) {

        Academician academician = academicianService.getById(assistant.getAcademician().getId());
        assistant.setAcademician(academician);

        assistantRepository.save(assistant);

        return new MessageResponse(ResponseType.SUCCESS, "Asistan başarıyla kaydedildi");
    }

    public MessageResponse updateAssistant(Long id, Assistant updateAssistant) {
        Assistant assistant = assistantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı"));

        Academician academician = academicianService.getById(assistant.getAcademician().getId());
        assistant.setAcademician(academician);

        assistant.update(updateAssistant);

        assistantRepository.save(assistant);

        return new MessageResponse(ResponseType.SUCCESS, "Asistan başarıyla güncellendi");
    }
    public Assistant getAssistantById(Long id) {
        return assistantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }

    public List<Assistant> getAllAssistant() {
        return assistantRepository.findAll();
    }

    public Assistant getById(Long id) {
        return assistantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı"));
    }

    public MessageResponse deleteAssistantById(Long id){
        assistantRepository.deleteById(id);
        return  new MessageResponse(ResponseType.SUCCESS, "Asistan başarıyla silindi");
    }


    public Assistant getAssistantByName(String name) {
        return assistantRepository.findAssistantByName(name)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }
}






















