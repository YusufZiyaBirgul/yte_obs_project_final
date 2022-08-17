package yte.obs_proje.yte_obs_proje.lesson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.obs_proje.yte_obs_proje.academician.entity.Academician;
import yte.obs_proje.yte_obs_proje.academician.service.AcademicianService;
import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;
import yte.obs_proje.yte_obs_proje.assistant.service.AssistantService;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.common.response.ResponseType;
import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;
import yte.obs_proje.yte_obs_proje.lesson.repository.LessonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {



    private final LessonRepository lessonRepository;
    private final AcademicianService academicianService;

    private final AssistantService assistantService;
    public MessageResponse addLesson(Lesson lesson) {

        Academician academician = academicianService.getById(lesson.getAcademician().getId());
        lesson.setAcademician(academician);

        Assistant assistant =assistantService.getById(lesson.getAssistant().getId());
        lesson.setAssistant(assistant);

        lessonRepository.save(lesson);
        return new MessageResponse(ResponseType.SUCCESS, "Ders kayıt işlemi başarılı");
    }

    public MessageResponse updateLesson(Lesson updateLesson, Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı"));

        Academician academician = academicianService.getById(lesson.getAcademician().getId());
        lesson.setAcademician(academician);

        lesson.update(updateLesson);

        lessonRepository.save(lesson);

        return new MessageResponse(ResponseType.SUCCESS, "Ders başarıyla güncellendi");
    }

    public MessageResponse deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Ders başarıyla silindi");
    }


    public List<Lesson> getAllLesson() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kayıt Bulunamadı"));
    }

}
