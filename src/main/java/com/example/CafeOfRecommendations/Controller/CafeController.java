package com.example.CafeOfRecommendations.Controller;

import com.example.CafeOfRecommendations.Entity.CafeEntity;
import com.example.CafeOfRecommendations.Exception.NoCoffeeNameForThePreference;
import com.example.CafeOfRecommendations.Service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cafes")
public class CafeController {
    @Autowired
    public CafeService cafeService;

    @GetMapping("/menu")
    public List<String> getMenu(){
        return cafeService.Menu();
    }


    @GetMapping("/{preference}")
    public ResponseEntity<List<String>> getCustomCoffee(@PathVariable String preference){

        List<String> coffeeName = cafeService.suggest(preference);

        return ResponseEntity.ok(coffeeName);
    }

    @PostMapping()
    public ResponseEntity<String> newCoffee(@RequestBody CafeEntity cafe){
        cafeService.saveCafe(cafe);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created new Coffee " + cafe.getCoffeeName()+ " with Preference " + cafe.getPreference());
    }

    @PostMapping("/add/{sNo}/{coffeeName}/{Preference}")
    public ResponseEntity<String> newCoffeeWithEndpoint(@PathVariable int sNo, @PathVariable String coffeeName, @PathVariable String Preference){

        cafeService.saveUrlCafe(sNo, coffeeName, Preference);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created new Coffee from URL Path");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCoffee(@RequestParam int sNo){
        cafeService.deleteCoffee(sNo);
        return ResponseEntity.status(HttpStatus.GONE).body("Deleted CoffeeName with sNo" + sNo);
    }
}
