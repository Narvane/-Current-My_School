package com.myportfolio.myschool.model.entity;

import com.myportfolio.myschool.model.contants.AttributeConstants;
import com.myportfolio.myschool.model.contants.ColumnConstants;
import com.myportfolio.myschool.model.contants.SequenceConstants;
import com.myportfolio.myschool.model.contants.TableConstants;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = TableConstants.DEGREE)
public class Degree implements AbstractEntity {

    @Id
    @Column(name = AttributeConstants.ID)
    @GeneratedValue(generator = SequenceConstants.GENERATE_DEGREE, strategy = SEQUENCE)
    @SequenceGenerator(name = SequenceConstants.GENERATE_DEGREE, sequenceName = SequenceConstants.NAME_DEGREE, allocationSize = 1)
    private Long id;

    @Column(name = ColumnConstants.NAME)
    private String name;

    @OneToMany(fetch = LAZY, mappedBy = ColumnConstants.DEGREE, cascade = ALL) // Bi-Directional
    private Set<Classroom> classrooms;

    @OneToMany(fetch = LAZY, mappedBy = ColumnConstants.DEGREE, cascade = ALL) // Bi-Directional
    private Set<Subject> subjects;

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
        classroom.setDegree(this);
    }

    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
        classroom.setDegree(null);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setDegree(this);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
        subject.setDegree(null);
    }
}
