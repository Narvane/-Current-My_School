package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.SUBJECT)
public class Subject implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_SUBJECT, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_SUBJECT, sequenceName = SequenceConstants.NAME_SUBJECT, allocationSize = 1)
    private Long id;

    @Column(name = ColumnConstants.NAME)
    private String name;

    @ManyToMany // [Owner] Bi-Directional
    @JoinTable(name=TableConstants.SUBJECT_PROFESSOR,
            joinColumns= {
                    @JoinColumn(name=ColumnConstants.SUBJECT_ID)
            },
            inverseJoinColumns= {
                    @JoinColumn(name=ColumnConstants.PROFESSOR_ID)
            })
    private Set<Professor> professors;

    @ManyToOne // Bi-Directional
    private Degree degree;

}
