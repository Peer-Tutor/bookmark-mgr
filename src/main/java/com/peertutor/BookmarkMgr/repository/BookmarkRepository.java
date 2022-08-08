package com.peertutor.BookmarkMgr.repository;

import com.peertutor.BookmarkMgr.model.Bookmark;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByLastName(String lastName);
    Bookmark findById(long id);
}

