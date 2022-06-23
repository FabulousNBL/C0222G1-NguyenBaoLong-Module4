package com.example.music.repository;

import com.example.music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MusicRepository extends JpaRepository<Song, Integer> {

    @Query(value = "select * from music", nativeQuery = true)
    List<Song> findAllMusic();

    @Modifying
    @Query(value = "insert into music (name, singer, type) values (:name, :singer, :type)",nativeQuery =true)
    void create(@Param("name") String name,
                @Param("singer") String singer,
                @Param("type") String type);

    @Modifying
    @Query(value = "update music set name = :name, singer= :singer, type = :type where id = :id", nativeQuery = true)
    void edit (@Param("name") String name,
               @Param("singer") String singer,
               @Param("type") String type,
               @Param("id") int id);

    @Query (value = "select * from music  where id = :id", nativeQuery= true)
    Song findById(@Param("id") int id);
}
