package com.example.islam.repository;

import com.example.islam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.lastName ilike :word or u.firstName ilike :word or u.country ilike :word")
    List<User> searchUser(@Param("word") String word);
}
