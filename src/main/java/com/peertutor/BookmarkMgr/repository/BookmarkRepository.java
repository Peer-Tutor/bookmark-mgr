package com.peertutor.BookmarkMgr.repository;

import com.peertutor.BookmarkMgr.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Bookmark findById(long id);
    Bookmark findByTutorID(long tutorID);

}

