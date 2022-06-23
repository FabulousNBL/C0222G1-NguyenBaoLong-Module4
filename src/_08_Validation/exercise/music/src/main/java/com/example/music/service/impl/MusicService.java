package com.example.music.service.impl;

import com.example.music.model.Song;
import com.example.music.repository.MusicRepository;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private MusicRepository musicRepository;


    @Override
    public List<Song> findAllMusic() {
        return musicRepository.findAllMusic();
    }

    @Override
    public void create(String name, String singer, String type) {
        musicRepository.create(name,singer,type);
    }

    @Override
    public void edit(String name, String singer, String type, int id) {
        musicRepository.edit(name, singer, type, id);
    }

    @Override
    public Song findById(int id) {
        return musicRepository.findById(id);
    }
}
