package com.example.islam.service.serviceImpl;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Namaz;
import com.example.islam.repository.NamazRepository;
import com.example.islam.service.NamazService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NamazServiceImpl implements NamazService {
    private final NamazRepository namazRepository;

    @Override
    public void saveNamaz(Namaz newNAmaz) {
        namazRepository.save(newNAmaz);
    }

    @Override
    public List<Namaz> findAllNamaz() {
        return namazRepository.findAll();
    }

    @Override
    public Namaz findAllById(Long namazId) {
        try {
            return namazRepository.findById(namazId).orElseThrow(() -> new MyException("Not found!"));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateNamaz(Long namazId, Namaz newNamaz) {
        try {
            Namaz namaz = namazRepository.findById(namazId).orElseThrow(() -> new MyException("Not found!"));
            namaz.setNamaztext1(newNamaz.getNamaztext1());
            namaz.setNamazText2(newNamaz.getNamazText2());
            namaz.setNamazText3(newNamaz.getNamazText3());
            namaz.setImage(newNamaz.getImage());
            namaz.setAudio(newNamaz.getAudio());
            namazRepository.save(namaz);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void deleteById(Long namazId) {
        namazRepository.deleteById(namazId);
    }

    @Override
    public List<Namaz> NamazSearch(String word) {
        String searchWord = word + "%";
        return namazRepository.searchNamaz(searchWord);
    }
}
