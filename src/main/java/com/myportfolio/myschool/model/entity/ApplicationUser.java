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
@Table(name = TableConstants.APPLICATION_USER)
public class ApplicationUser implements AbstractEntity {
    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_APPLICATION_USER, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_APPLICATION_USER, sequenceName = SequenceConstants.NAME_APPLICATION_USER, allocationSize = 1)
    private Long id;

    @Column(name = ColumnConstants.EMAIL)
    private String email;

    @Column(name = ColumnConstants.USERNAME)
    private String username;

    @Column(name = ColumnConstants.PASSWORD)
    private String password;

}
