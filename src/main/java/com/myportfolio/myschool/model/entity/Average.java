package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.AVERAGE)
public class Average implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_AVERAGE, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_AVERAGE, sequenceName = SequenceConstants.NAME_AVERAGE, allocationSize = 1)
    private Long id;

    @ManyToOne // One-Directional
    @JoinColumn(name = ColumnConstants.SUBJECT_ID)
    private Subject subject;

    @Column(name = ColumnConstants.VALUE)
    private Double value;

    @OneToMany(orphanRemoval = true) // One-Directional
    @JoinColumn(name = ColumnConstants.AVERAGE_ID)
    private Set<Grade> grades;

}
