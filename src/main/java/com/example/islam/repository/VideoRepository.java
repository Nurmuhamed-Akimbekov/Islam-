package com.example.islam.repository;

import com.example.islam.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepository  extends JpaRepository<Video, Long> {

}
