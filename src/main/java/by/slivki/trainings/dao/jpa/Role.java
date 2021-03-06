package by.slivki.trainings.dao.jpa;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@Entity
@Table(name="roles")
public class Role {
    @Column
    @Id
    private int roleId;
    @Column
    private String roleName;

    public Role() {
    }

    public Role(RoleEnum roleEnum) {
        this.roleId = roleEnum.getI();
        this.roleName = roleEnum.name();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
