package com.example.islam.repository;

import com.example.islam.entity.NamazTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamaztimeRepository extends JpaRepository<NamazTime, Long> {

}
