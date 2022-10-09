package com.peertutor.BookmarkMgr.service;

import com.peertutor.BookmarkMgr.model.Bookmark;
import com.peertutor.BookmarkMgr.model.viewmodel.request.BookmarkReq;
import com.peertutor.BookmarkMgr.repository.BookmarkRepository;
import com.peertutor.BookmarkMgr.service.dto.BookmarkDTO;
import com.peertutor.BookmarkMgr.service.mapper.BookmarkMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    private static final Logger logger = LoggerFactory.getLogger(BookmarkService.class);
    @Autowired
    private final BookmarkMapper bookmarkMapper;
    @Autowired
    private BookmarkRepository bookmarkRepository;


    public BookmarkService(BookmarkRepository bookmarkRepository, BookmarkMapper bookmarkMapper) {
        this.bookmarkRepository = bookmarkRepository;
        this.bookmarkMapper = bookmarkMapper;
    }

    // get bookmark by student id
    public BookmarkDTO getBookmark(Long id) {
        Bookmark bookmark;
        bookmark = bookmarkRepository.findByStudentID(id);

        if (bookmark == null) {
            return null;
        }
        BookmarkDTO result = bookmarkMapper.toDto(bookmark);

        return result;
    }

    // create bookmark by tutor id
    public BookmarkDTO createBookmark(BookmarkReq req){
        Bookmark bookmark = bookmarkRepository.findByTutorID(req.id);

        // if is new create new bookmark
        if(bookmark == null) {
            bookmark = new Bookmark();
            bookmark.setID(req.id);
            bookmark.setTutorID(req.tutorID);
            bookmark.setStudentID(req.studentID);
        }

        try {
            bookmark = bookmarkRepository.save(bookmark);
        } catch (Exception e) {
            logger.error("Bookmark Creation Failed: " + e.getMessage());
            return null;
        }

        BookmarkDTO result = bookmarkMapper.toDto(bookmark);

        return result;
    }

}
