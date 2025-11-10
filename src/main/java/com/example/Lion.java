package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Specimen specimen;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public Lion(Specimen specimen){
        this.specimen = specimen;
    }

    public int getKittens() {
        return specimen.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return specimen.getFood("Хищник");
    }
}