package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.PROFESSOR)
public class Professor implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_PROFESSOR, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_PROFESSOR, sequenceName = SequenceConstants.NAME_PROFESSOR, allocationSize = 1)
    private Long id;

    @OneToOne(cascade = ALL) // One-Directional
    @JoinColumn(name = ColumnConstants.APPLICATION_USER_ID)
    private ApplicationUser applicationUser;

    @ManyToMany(mappedBy=AttributeConstants.PROFESSORS) // [Owned] Bi-Directional
    private Set<Subject> subjects;

    @Column(name = ColumnConstants.NAME)
    private String name;
}
