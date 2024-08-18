package com.example.islam.service;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Xadis;

import java.util.List;

public interface XadisService {
    void saveXadis(Xadis newXadis);

    List<Xadis> findAllXadis();

    Xadis findById(Long xadisId) throws MyException;

    void updateXadis(Long xadisId, Xadis newXadis);

    void deleteXadisById(Long xadisId);

    List<Xadis> XadisSearch(String word);
}
