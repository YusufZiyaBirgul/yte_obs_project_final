package yte.obs_proje.yte_obs_proje.admin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.obs_proje.yte_obs_proje.admin.controller.requests.AddAdminRequest;
import yte.obs_proje.yte_obs_proje.admin.controller.requests.UpdateAdminRequest;
import yte.obs_proje.yte_obs_proje.admin.controller.responses.AdminQueryModel;
import yte.obs_proje.yte_obs_proje.admin.service.AdminService;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {


    private final AdminService adminService;

    @PostMapping
    public MessageResponse addAdmin(@Valid @RequestBody AddAdminRequest addAdminRequest) {
        return adminService.addAdmin(addAdminRequest.toDomainEntity());

    }

    @PutMapping("{id}")
    public MessageResponse updateAdmin(@Valid @RequestBody UpdateAdminRequest updateAdminRequest, @PathVariable Long id) {
        return adminService.updateAdmin(id, updateAdminRequest.toDomainEntity());
    }

    @DeleteMapping("{id}")
    public MessageResponse deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdminById(id);
    }


    @GetMapping("{id}")
    public AdminQueryModel getAdminById(@PathVariable Long id) {
        return new AdminQueryModel(adminService.getById(id));
    }

    @GetMapping
    public List<AdminQueryModel> getAllAdmins() {

        return adminService.getAllAdmin()
                .stream()
                .map(admin -> new AdminQueryModel(admin))
                .toList();
    }

}
