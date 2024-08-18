package com.example.islam.repository;

import com.example.islam.entity.Namaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NamazRepository extends JpaRepository<Namaz, Long> {
    @Query("select n from Namaz n where " +
            "n.namaztext1 ilike (:word)" +
            "or n.namazText2 ilike (:word) or n.namazText3 ilike (:word)")
    List<Namaz> searchNamaz(String word);
}
