package com.udacity.gradle.jokes.library;

public class JokesProvider {

    static int index = 0;
    private static String[] jokes = {"Give a man a fish and he will eat for a day. Teach him how to fish and he will sit in a boat and drink beer all day.",
    "Do not be racist; be like Mario. He's an Italian plumber, who was made by the Japanese, speaks English, looks like a Mexican, jumps like a black man, and grabs coins like a Jew!",
    "What happens to a frog's car when it breaks down?\n It gets toad away.",
            "Q: Can a kangaroo jump higher than the Empire State Building? \n A: Of course. The Empire State Building can't jump.",
    "Q. What did the elephant say to the naked man? \n A. How do you breathe through something so small?",
            "How did the blonde try to kill the bird?? She threw it off a cliff.",
            "The energizer bunny was arrested on a charge of battery.",
            "Why did the chicken cross the playground? To get to the other slide!!",
            "Why did the turkey cross the road? Because he wasn't a chicken.",
            "Two fish are in a tank. One turns to the other and says: Hey, do you know how to drive this thing?"
    };

    public static String getJoke() {
        String joke = "";
        if(index < jokes.length) {
            joke = jokes[index];
            index++;
            if(index >= jokes.length) {
                index = 0;
            }
        }
        return joke;
    }
}
