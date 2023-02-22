package codegym.danang.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private codegym.danang.demo.model.AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "Role_Id", nullable = false)
    private codegym.danang.demo.model.AppRole appRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public codegym.danang.demo.model.AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(codegym.danang.demo.model.AppUser appUser) {
        this.appUser = appUser;
    }

    public codegym.danang.demo.model.AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(codegym.danang.demo.model.AppRole appRole) {
        this.appRole = appRole;
    }

}
