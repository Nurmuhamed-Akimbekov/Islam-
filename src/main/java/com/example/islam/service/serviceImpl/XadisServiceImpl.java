package com.example.islam.service.serviceImpl;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.Xadis;
import com.example.islam.repository.XadisRepository;
import com.example.islam.service.XadisService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional

public class XadisServiceImpl implements XadisService {

    private final XadisRepository xadisRepository;

    @Override
    public void saveXadis(Xadis newXadis) {
        xadisRepository.save(newXadis);
    }

    @Override
    public List<Xadis> findAllXadis() {
        return xadisRepository.findAll();
    }

    @Override
    public Xadis findById(Long xadisId) throws MyException {
        return xadisRepository.findById(xadisId).orElseThrow(() -> new MyException("Hadis not found!"));
    }

    @Override
    public void updateXadis(Long xadisId, Xadis newXadis) {
        try {
            Xadis xadis = xadisRepository.findById(xadisId).orElseThrow(() -> new MyException("Hadis not found!"));
            xadis.setXadisText(newXadis.getXadisText());
            xadisRepository.save(xadis);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteXadisById(Long xadisId) {
        xadisRepository.deleteById(xadisId);
    }

    @Override
    public List<Xadis> XadisSearch(String word) {
        String searchWord = word + "%";
        return xadisRepository.searchXadis(searchWord);
    }


}
