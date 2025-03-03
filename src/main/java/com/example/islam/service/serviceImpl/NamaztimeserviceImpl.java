package com.example.islam.service.serviceImpl;

import com.example.islam.MyExeption.MyException;
import com.example.islam.entity.NamazTime;
import com.example.islam.repository.NamaztimeRepository;
import com.example.islam.service.NamaztimeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class NamaztimeserviceImpl implements NamaztimeService {
    private final NamaztimeRepository namaztimeRepository;
    @Override
    public void saveNamaxtime(NamazTime newNamazTime) {
        namaztimeRepository.save(newNamazTime);
    }

    @Override
    public List<NamazTime> findAllNamazTime() {
        return namaztimeRepository.findAll();
    }

    @Override
    public NamazTime findById(Long namazTimeId) throws MyException {
        return namaztimeRepository.findById(namazTimeId).orElseThrow(()-> new MyException("Not found id"));
    }

    @Override
    public void updateNamazTimeById(Long namaztimeId, NamazTime newNamazTime) {
        try {
            NamazTime namazTime = namaztimeRepository.findById(namaztimeId).orElseThrow(() -> new MyException("Not found id"));
            namazTime.setCityName(newNamazTime.getCityName());
            namazTime.setBagymdatTime(newNamazTime.getBagymdatTime());
            namazTime.setKunChyguuTime(newNamazTime.getKunChyguuTime());
            namazTime.setBechimTime(newNamazTime.getBechimTime());
            namazTime.setAsrTime(newNamazTime.getAsrTime());
            namazTime.setKuptanTime(newNamazTime.getKuptanTime());
            namazTime.setTahadjutTime(newNamazTime.getTahadjutTime());
            namaztimeRepository.save(namazTime);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void deleteNamazTimeId(Long namazTimeId) {
        namaztimeRepository.deleteById(namazTimeId);
    }
}
