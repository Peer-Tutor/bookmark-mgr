package com.peertutor.BookmarkMgr.model.viewmodel.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookmarkReq {
    @NotNull
    @NotEmpty
    public String name;

    @NotNull
    @NotEmpty
    public String sessionToken;

    @NotNull
    @NotEmpty
    public Long id;

    @NotNull
    @NotEmpty
    public Long tutorID;

    @NotNull
    @NotEmpty
    public Long studentID;
}