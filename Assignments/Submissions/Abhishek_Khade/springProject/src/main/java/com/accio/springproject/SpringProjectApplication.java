package com.accio.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringProjectApplication {
    @GetMapping("/hii")

    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("playList/{id}/songs/{songId}")

    public String playListSongs(@PathVariable int id, @PathVariable int songId) {
        return "PlayList " + id + " song " + songId;
    }

    @GetMapping("playList/{id}")

    public String playListSongs(@PathVariable int id) {
        return "PlayList " + id ;
    }



    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);

    }

}
