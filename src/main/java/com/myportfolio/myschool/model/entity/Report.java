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
@Table(name = TableConstants.REPORT)
public class Report implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_REPORT, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_REPORT, sequenceName = SequenceConstants.NAME_REPORT, allocationSize = 1)
    private Long id;

    @ManyToOne // Bi-Directional
    private Student student;

    @ManyToOne // One-Directional
    @JoinColumn(name = ColumnConstants.PERIOD_ID)
    private Period period;

    @OneToMany(orphanRemoval = true) // One-Directional
    @JoinColumn(name = ColumnConstants.REPORT_ID)
    private Set<Average> averages;

}
