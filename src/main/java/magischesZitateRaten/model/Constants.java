package com.amazon.ask.quiz.model;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static boolean USE_CARDS_FLAG = true;

    public static String WELCOME_MESSAGE = "Danke für das Öffnen von Magische Zitate Raten. In diesem Spiel geht es darum," +
            " alleine oder gegen einen zweiten Spieler Zitate zu erraten. Der Gewinner steht an der Spitze des High-Scores. Spielst du alleine oder zu zweit?";

    // This is the message a user will hear when they try to cancel or stop the
    // skill, or when they finish a quiz.
    public static String EXIT_SKILL_MESSAGE = "Vielen Dank für das Spielen von Magisches Zitate Raten. Bis bald!";

    // This is the message a user will hear when they ask Alexa for help in your
    // skill.
    public static String HELP_MESSAGE = "Danke für das Öffnen von Magische Zitate Raten. In diesem Spiel geht es darum, alleine oder gegen einen zweiten Spieler Zitate zu erraten. Der Gewinner steht an der Spitze des High-Scores.";

    public static List<String> CORRECT_RESPONSES = Arrays.asList("Booya", "All righty", "Bam", "Bazinga", "Bingo", "Boom", "Bravo", "Cha Ching", "Cheers", "Dynomite",
            "Hip hip hooray", "Hurrah", "Hurray", "Huzzah", "Oh dear.  Just kidding.  Hurray", "Kaboom", "Kaching", "Oh snap", "Phew",
            "Righto", "Way to go", "Well done", "Whee", "Woo hoo", "Yay", "Wowza", "Yowsa");

    public static List<String> INCORRECT_RESPONSES = Arrays.asList("Argh", "Aw man", "Blarg", "Blast", "Boo", "Bummer", "Darn", "D'oh", "Dun dun dun", "Eek", "Honk", "Le sigh",
            "Mamma mia", "Oh boy", "Oh dear", "Oof", "Ouch", "Ruh roh", "Shucks", "Uh oh", "Wah wah", "Whoops a daisy", "Yikes");

}