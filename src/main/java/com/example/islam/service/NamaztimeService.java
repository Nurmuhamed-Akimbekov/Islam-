package com.example.islam.service;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.NamazTime;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface NamaztimeService {

    void saveNamaxtime(NamazTime newNamazTime);

    List<NamazTime> findAllNamazTime();

    NamazTime findById(Long namazTimeId) throws MyException;

    void updateNamazTimeById(Long namaztimeId, NamazTime newNamazTime);

    void deleteNamazTimeId(Long namazTimeId);
}
