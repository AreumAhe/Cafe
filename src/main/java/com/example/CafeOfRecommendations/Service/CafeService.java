package com.example.CafeOfRecommendations.Service;

import com.example.CafeOfRecommendations.Exception.NoCoffeeNameForThePreference;
import com.example.CafeOfRecommendations.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
