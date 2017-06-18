package com.memoseed.joketellerjava;

import java.util.Random;

public class Jokes {
    private Random random = new Random();
    String [] jokes = new String []{"What is the difference between a snowman and a snowwoman?\nSnowballs.",
    "Anton, do you think I’m a bad mother?\nMy name is Paul.",
    "Optimist: The glass is half full.\nPessimist: The glass is half empty.\nMother: Why didn’t you use a coaster!",
    "How many gorillas can fit into a car?\nEight.\nHow many chickens can fit into the car?\nNone, the car is already full of gorillas",
    "Coco Chanel once said that you should put perfume on places where you want to be kissed by a man. But hell does that burn!"};

    public String getJoke(){
        return jokes[random.nextInt(jokes.length)];
    }
}
