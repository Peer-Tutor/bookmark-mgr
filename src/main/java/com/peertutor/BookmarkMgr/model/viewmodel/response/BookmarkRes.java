package com.peertutor.BookmarkMgr.model.viewmodel.response;

import com.peertutor.BookmarkMgr.service.dto.BookmarkDTO;

public class BookmarkRes {

    public Long id;
    public Long tutorID;
    public Long studentID;

    public BookmarkRes(BookmarkDTO bookmarkDto){
        this.id = bookmarkDto.getID();
        this.tutorID = bookmarkDto.getTutorID();
        this.studentID = bookmarkDto.getStudentID();
    }
}
