package com.example.islam.service;


import com.example.islam.entity.Video;

import java.util.List;

public interface VideoService {

    void saveVideo (Video newVideo);

    List<Video> findAllVideo();

    Video findVideoById(Long videoId);

    void deleteVideoById(Long videoId);


}
