package com.example.CafeOfRecommendations.Controller;

import com.example.CafeOfRecommendations.Service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cafes")
public class CafeController {
    @Autowired
    public CafeService cafeService;

//    @GetMapping("/menu")
//    public List<String> getMenu(){
//        return cafeService.Menu;
//    }

    @GetMapping("/{preference}")
    public ResponseEntity<List<String>> getCustomCoffee(@PathVariable String preference){

        List<String> coffeeName = cafeService.suggest(preference);

//        if (coffeeName == null || coffeeName.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }

        return ResponseEntity.ok(coffeeName);
    }

}
