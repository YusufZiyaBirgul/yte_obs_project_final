package yte.obs_proje.yte_obs_proje.exam.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.common.response.ResponseType;
import yte.obs_proje.yte_obs_proje.exam.entity.Exam;
import yte.obs_proje.yte_obs_proje.exam.repository.ExamRepository;
import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;
import yte.obs_proje.yte_obs_proje.lesson.service.LessonService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {


    private final ExamRepository examRepository;
    private final LessonService lessonService;

    public MessageResponse addExam(Exam exam) {
        Lesson lesson = lessonService.getLessonById(exam.getLesson().getId());
        exam.setLesson(lesson);

        examRepository.save(exam);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla kaydedildi");
    }

    public MessageResponse updateExam(Long id, Exam updateExam) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

        examRepository.save(updateExam);

        updateExam.update(exam);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla güncellendi");
    }

    public MessageResponse deleteExamById(Long id) {
        examRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla silindi");
    }

    public List<Exam> getAllExam() {
        return examRepository.findAll();
    }


    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }

    @GetMapping("{id}")
    public Exam getById(@PathVariable Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

    }

}

