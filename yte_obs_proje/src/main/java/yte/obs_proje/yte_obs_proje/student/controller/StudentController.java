package yte.obs_proje.yte_obs_proje.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.security.AuthenticationService;
import yte.obs_proje.yte_obs_proje.security.Role;
import yte.obs_proje.yte_obs_proje.security.Users;
import yte.obs_proje.yte_obs_proje.student.controller.requests.AddStudentRequest;
import yte.obs_proje.yte_obs_proje.student.controller.requests.UpdateStudentRequest;
import yte.obs_proje.yte_obs_proje.student.controller.responses.StudentQueryModel;
import yte.obs_proje.yte_obs_proje.student.entity.Student;
import yte.obs_proje.yte_obs_proje.student.service.StudentService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;



    @PostMapping()
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse addStudent(@Valid @RequestBody AddStudentRequest addStudentRequest) {
        Users a = new Users();
        a.setPassword("");
        a.setRole(Role.Academician);
        a.setUsername("");

        return studentService.addStudent(addStudentRequest.toDomainEntity());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public List<StudentQueryModel> getAllStudents() {

        return studentService.getAllStudents()
                .stream()
                .map(student -> new StudentQueryModel(student))
                .toList();
    }

    @GetMapping("/{id}")
    public StudentQueryModel getById(@NotNull @PathVariable Long id) {
        return new StudentQueryModel(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse deleteStudentById(@PathVariable @NotNull Long id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse updateStudent(@Valid @RequestBody UpdateStudentRequest request, @PathVariable Long id) {
        return studentService.updateStudent(id, request.toDomainEntity());
    }
}
