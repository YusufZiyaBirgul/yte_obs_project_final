package yte.obs_proje.yte_obs_proje.admin.entity;

import lombok.Getter;
import lombok.Setter;
import yte.obs_proje.yte_obs_proje.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Admin extends BaseEntity {

  private  String username;
    private  String Password;

    public Admin() {
    }

    public Admin(String username, String password) {
        this.username = username;
        this.Password = password;
    }


    public void update(Admin admin) {

    }
}
