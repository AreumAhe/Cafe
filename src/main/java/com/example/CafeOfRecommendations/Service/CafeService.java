package com.example.CafeOfRecommendations.Service;

import com.example.CafeOfRecommendations.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    public String suggest (String Preference){

        return cafeRepository.findCoffeeNameByPreference(Preference);
    }

}
