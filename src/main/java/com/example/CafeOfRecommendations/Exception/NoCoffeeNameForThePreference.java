package com.example.CafeOfRecommendations.Exception;

public class NoCoffeeNameForThePreference extends RuntimeException{
    public NoCoffeeNameForThePreference(String message) {
        super(message);
    }
}
