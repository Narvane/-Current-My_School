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
@Table(name = TableConstants.PERIOD)
public class Period implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_PERIOD, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_PERIOD, sequenceName = SequenceConstants.NAME_PERIOD, allocationSize = 1)
    private Long id;

    @Column(name = ColumnConstants.NAME)
    private String name;
}
