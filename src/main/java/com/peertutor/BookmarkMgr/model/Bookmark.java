package com.peertutor.BookmarkMgr.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "bookmark")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tutor_id", nullable = false, unique = true)
    private Long tutorID;

    @Column(name = "student_id", nullable = false)
    private Long studentID;

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getTutorID() {
        return tutorID;
    }

    public void setTutorID(Long id) {
        this.tutorID = id;
    }

    public Long getStudentID() { return studentID; }

    public void setStudentID(Long id) {
        this.studentID = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Bookmark bookmark = (Bookmark) o;
        if (bookmark.getID() == null || getID() == null) {
            return false;
        }
        return Objects.equals(getID(), bookmark.getID());
    }

    @Override
    public String toString() {
        return "Bookmark {" +
                "id=" + id +
                ", Tutor ID='" + tutorID + '\'' +
                ", Student ID='" + studentID + '\'' +
                '}';
    }
}
