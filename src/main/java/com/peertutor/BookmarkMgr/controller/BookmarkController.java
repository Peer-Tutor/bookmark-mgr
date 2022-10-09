package com.peertutor.BookmarkMgr.controller;

import com.peertutor.BookmarkMgr.model.viewmodel.request.BookmarkReq;
import com.peertutor.BookmarkMgr.model.viewmodel.response.BookmarkRes;
import com.peertutor.BookmarkMgr.repository.BookmarkRepository;
import com.peertutor.BookmarkMgr.service.AuthService;
import com.peertutor.BookmarkMgr.service.BookmarkService;
import com.peertutor.BookmarkMgr.util.AppConfig;
import com.peertutor.BookmarkMgr.model.Bookmark;
import com.peertutor.BookmarkMgr.service.dto.BookmarkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(path="/bookmark-mgr")
public class BookmarkController {
    @Autowired
    AppConfig appConfig;
    @Autowired
    private BookmarkRepository bookmarkRepository;// = new CustomerRepository();
    @Autowired
    private BookmarkService bookmarkService;
    @Autowired
    private AuthService authService;
    @GetMapping(path="/health")
    public @ResponseBody String healthCheck(){
        return "Ok 2";
    }

    @PostMapping(path = "/bookmark")
    public @ResponseBody ResponseEntity<BookmarkRes> createBookmark(@RequestBody @Valid BookmarkReq req) {
        boolean result = authService.getAuthentication(req.name, req.sessionToken);
        if (!result) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        BookmarkDTO savedBookmark;

        savedBookmark = bookmarkService.createBookmark(req);

        if (savedBookmark == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        BookmarkRes res = new BookmarkRes(savedBookmark);

        return ResponseEntity.ok().body(res);
    }

    @GetMapping(path = "/bookmark")
    public @ResponseBody ResponseEntity<BookmarkRes> getBookmark(@RequestBody @Valid BookmarkReq req) {
        boolean result = authService.getAuthentication(req.name, req.sessionToken);
        if (!result) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        BookmarkDTO bookmarkRetrieved;
        bookmarkRetrieved = bookmarkService.getBookmark(req.id);

        if (bookmarkRetrieved == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        BookmarkRes res = new BookmarkRes(bookmarkRetrieved);

        return ResponseEntity.ok().body(res);
    }


}
