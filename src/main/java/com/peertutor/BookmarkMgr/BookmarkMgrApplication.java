package com.peertutor.BookmarkMgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BookmarkMgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkMgrApplication.class, args);
	}

}
