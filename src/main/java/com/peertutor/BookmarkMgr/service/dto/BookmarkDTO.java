package com.peertutor.BookmarkMgr.service.dto;

import com.peertutor.BookmarkMgr.model.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookmarkDTO implements Serializable {

    private Long id;
    private Long tutorID;
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
    public int hashCode() {
        return Objects.hashCode(getID());
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
