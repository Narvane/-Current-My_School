package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.STUDENT)
public class Student implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_STUDENT, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_STUDENT, sequenceName = SequenceConstants.NAME_STUDENT, allocationSize = 1)
    private Long id;

    @OneToOne(cascade = ALL) // One-Directional
    @JoinColumn(name = ColumnConstants.APPLICATION_USER_ID)
    private ApplicationUser applicationUser;

    @Column(name = ColumnConstants.NAME)
    private String name;

    @OneToMany(fetch = LAZY, mappedBy = AttributeConstants.STUDENT, cascade = ALL, orphanRemoval = true) // Bi-Directional
    private Set<Report> reports;

    public void addReport(Report report) {
        reports.add(report);
        report.setStudent(this);
    }

    public void removeReport(Report report) {
        reports.remove(report);
        report.setStudent(null);
    }

}
