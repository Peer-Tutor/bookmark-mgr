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

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<BookmarkDTO> getBookmark(Long studentId) {
        List<Bookmark> bookmark = bookmarkRepository.findByStudentID(studentId);

        if (bookmark == null) {
            return null;
        }
        List<BookmarkDTO> result = bookmarkMapper.toDto(bookmark);

        return result;
    }

    // create bookmark by tutor id
    public BookmarkDTO createBookmark(BookmarkReq req){
        Optional<Bookmark> bookmarkOptional;

        if (req.id != null) {
            bookmarkOptional = bookmarkRepository.findById(req.id);
        } else {
            bookmarkOptional = bookmarkRepository.findByTutorIDAndStudentID(req.tutorID, req.studentID);
        }

        Bookmark bookmark;

        // if is new create new bookmark
        if(!bookmarkOptional.isPresent()) {
            bookmark = new Bookmark();
        } else {
            bookmark = bookmarkOptional.get();
        }

        bookmark.setTutorID(req.tutorID);
        bookmark.setStudentID(req.studentID);

        try {
            bookmark = bookmarkRepository.save(bookmark);
        } catch (Exception e) {
            logger.error("Bookmark Creation Failed: " + e.getMessage());
            return null;
        }

        BookmarkDTO result = bookmarkMapper.toDto(bookmark);

        return result;
    }

    public void deleteBookmarkById(Long id) {
        bookmarkRepository.deleteById(id);
    }

    public void deleteBookmarkByStudentAndTutor(Long studentId, Long tutorId) {
        bookmarkRepository.deleteByTutorIDAndStudentID(tutorId, studentId);
    }
}
