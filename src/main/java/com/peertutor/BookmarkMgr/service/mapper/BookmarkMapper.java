package com.peertutor.BookmarkMgr.service.mapper;

import com.peertutor.BookmarkMgr.model.Bookmark;
import com.peertutor.BookmarkMgr.service.dto.BookmarkDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link com.peertutor.BookmarkMgr.model.Bookmark} and its DTO {@link BookmarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookmarkMapper extends EntityMapper<BookmarkDTO, Bookmark> {

    Bookmark toEntity(BookmarkDTO bookmarkDTO);

    BookmarkDTO toDto(Bookmark bookmark);

    default Bookmark fromID(Long id) {
        if (id == null) {
            return null;
        }
        Bookmark bookmark = new Bookmark();
        bookmark.setID(id);
        return bookmark;
    }
}
