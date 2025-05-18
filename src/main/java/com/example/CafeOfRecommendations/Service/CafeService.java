package com.example.CafeOfRecommendations.Service;

import com.example.CafeOfRecommendations.Entity.CafeEntity;
import com.example.CafeOfRecommendations.Exception.NoCoffeeNameForThePreference;
import com.example.CafeOfRecommendations.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    public List<String> suggest (String Preference){

        List<String> coffeeNames = cafeRepository.findCoffeeNameByPreference(Preference);
        if (coffeeNames == null || coffeeNames.isEmpty()) {
            throw new NoCoffeeNameForThePreference("No coffee found for preference: " + Preference);
        }
        return coffeeNames;
    }

//    public List<String> suggestByPreference(String preference) {
////        return cafeRepository.findByPreference(preference)
////                .stream()
////                .map(CafeEntity::getCoffeeName)
////                .toList(); // Java 16+ or use collect(Collectors.toList())
//    CafeEntity cafe = cafeRepository.findByPreference(preference);
//    List<String> bleh = cafe.getCoffeeName();
//    return bleh;
//    }

    public List<String> Menu() {
        return cafeRepository.findCoffeeNames();
    }

    public void saveCafe(CafeEntity cafeEntity) {
        cafeRepository.save(cafeEntity);
    }

    public void saveUrlCafe(int sNo, String coffeeName, String Preference){
        CafeEntity cafeEntity = new CafeEntity();

        cafeEntity.setCoffeeName(coffeeName);
        cafeEntity.setPreference(Preference);
        cafeEntity.setsNo(sNo);

        saveCafe(cafeEntity);
    }

    public void deleteCoffee(int sNo) {
        if(cafeRepository.existsById(sNo))
            cafeRepository.deleteById(sNo);
        else
            throw new NoSuchElementException("No record found with sNo " + sNo);
    }
}
