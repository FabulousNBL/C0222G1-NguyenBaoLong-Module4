package com.example.music.service;

import com.example.music.model.Song;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMusicService {

    List<Song> findAllMusic();

    void create( String name,
                 String singer,
                String type);


    void edit( String name,
                 String singer,
                 String type,int id);

    Song findById( int id);
}
