package com.example.islam.service;

import com.example.islam.entity.Namaz;

import java.util.List;

public interface NamazService {

    void saveNamaz(Namaz newNAmaz);

    List<Namaz> findAllNamaz();

    Namaz findAllById(Long namazId);

    void updateNamaz(Long namazId, Namaz newNamaz);

    void deleteById(Long namazId);

    List<Namaz> NamazSearch(String word);

}
