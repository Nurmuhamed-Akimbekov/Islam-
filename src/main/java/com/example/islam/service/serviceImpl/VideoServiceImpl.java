package com.example.islam.service.serviceImpl;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Video;
import com.example.islam.repository.UserRepository;
import com.example.islam.repository.VideoRepository;
import com.example.islam.service.VideoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    @Override
    public void saveVideo(Video newVideo) {
        videoRepository.save(newVideo);
    }

    @Override
    public List<Video> findAllVideo() {
        return videoRepository.findAll();
    }

    @Override
    public Video findVideoById(Long videoId) {
        try {
            return videoRepository.findById(videoId).orElseThrow(() -> new MyException("Video not found!"));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteVideoById(Long videoId) {
        videoRepository.deleteById(videoId);
    }


}
