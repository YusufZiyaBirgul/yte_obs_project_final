package yte.obs_proje.yte_obs_proje.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;
import yte.obs_proje.yte_obs_proje.assistant.service.AssistantService;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.common.response.ResponseType;
import yte.obs_proje.yte_obs_proje.homework.entity.Homework;
import yte.obs_proje.yte_obs_proje.homework.repository.HomeworkRepository;
import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;
import yte.obs_proje.yte_obs_proje.lesson.service.LessonService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private  final HomeworkRepository homeworkRepository;

    private  final AssistantService assistantService;

    private final LessonService lessonService;


    public MessageResponse addHomework(Homework homework) {
        Lesson lesson = lessonService.getLessonById(homework.getLesson().getId());
        homework.setLesson(lesson);

        Assistant assistant=assistantService.getAssistantById(homework.getAssistant().getId());
        homework.setAssistant(assistant);

        homeworkRepository.save(homework);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla kaydedildi");
    }

    public MessageResponse updateHomework(Long id, Homework updateHomework) {
        Homework homework = homeworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

        homeworkRepository.save(updateHomework);

        updateHomework.update(homework);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla güncellendi");
    }

    public MessageResponse deleteHomeworkById(Long id) {
        homeworkRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla silindi");
    }

    public List<Homework> getAllHomework() {
        return homeworkRepository.findAll();
    }


    public Homework getHomeworkById(Long id) {
        return homeworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }

    @GetMapping("{id}")
    public Homework getById(@PathVariable Long id) {
        return homeworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

    }
}
