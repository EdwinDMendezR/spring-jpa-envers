package spring.entity;

import lombok.*;
import org.hibernate.envers.Audited;
import spring.config.audit.PersonAuditEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Audited
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person extends PersonAuditEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;

}
