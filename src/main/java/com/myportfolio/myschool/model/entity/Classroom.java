package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.CLASSROOM)
public class Classroom implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_CLASSROOM, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_CLASSROOM, sequenceName = SequenceConstants.NAME_CLASSROOM, allocationSize = 1)
    private Long id;

    @Column(name = ColumnConstants.IDENTIFIER)
    private String identifier;

    @ManyToOne // Bi-Directional
    private Degree degree;

}
