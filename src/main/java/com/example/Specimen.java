package com.example;

import java.util.List;

public interface Specimen {
    int getKittens();
    List<String> getFood(String animalKind) throws Exception;
}
