package com.example.islam.repository;

import com.example.islam.entity.Xadis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface XadisRepository extends JpaRepository<Xadis, Long> {

    @Query("select x from Xadis x where x.xadisText ilike (:word)")
    List<Xadis> searchXadis(String word);
}
