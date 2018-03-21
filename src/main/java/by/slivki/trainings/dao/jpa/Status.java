package by.slivki.trainings.dao.jpa;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="statuses")
public class Status {
    @Column
    @Id
    private int statusId;
    @Column
    private String statusName;

    public Status(StatusEnum statusEnum) {
        this.statusId = statusEnum.getI();
        this.statusName = statusEnum.name();
    }
}
