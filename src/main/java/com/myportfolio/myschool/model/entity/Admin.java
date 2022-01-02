package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.ADMIN)
public class Admin implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_ADMIN, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_ADMIN, sequenceName = SequenceConstants.NAME_ADMIN, allocationSize = 1)
    private Long id;

    @OneToOne(cascade = ALL) // One-Directional
    @JoinColumn(name = ColumnConstants.APPLICATION_USER_ID)
    private ApplicationUser applicationUser;

    @Column(name = ColumnConstants.NAME)
    private String name;

}
