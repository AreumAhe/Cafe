package com.example.CafeOfRecommendations.Repository;

import com.example.CafeOfRecommendations.Entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Integer> {

    @Query("SELECT c.coffeeName FROM CafeEntity c WHERE c.preference = ?1")
    List<String> findCoffeeNameByPreference(String preference);

    @Query("SELECT c.coffeeName FROM CafeEntity c")
    List<String> findCoffeeNames();

//    CafeEntity findByPreference(String preference);
}
