package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.quiz.model.Constants;



import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestConstants {

    @Test
    public void doTestConstants() {


        String a = "Willkommen bei Magisches Zitate Raten! In diesem Spiel teste ich dein Zitate-Wissen. Denn nur der Beste schafft es durch den Zauberwald. Spielst du alleine oder zu zweit?";

        // This is the message a user will hear when they try to cancel or stop the
        // skill, or when they finish a quiz.
        String b = "Vielen Dank für das Spielen von Magisches Zitate Raten. Bis bald!";

        // This is the message a user will hear when they ask Alexa for help in your
        // skill.
        String c = "Dies ist die Hilfe-Funktion von Magisches Zitate Raten. In diesem Spiel geht es darum, alleine oder gegen einen zweiten Spieler Zitate zu erraten. Der Gewinner steht an der Spitze des High-Scores.";

        assertEquals(a, Constants.WELCOME_MESSAGE);
        assertEquals(b, Constants.EXIT_SKILL_MESSAGE);
        assertEquals(c, Constants.HELP_MESSAGE);
    }

}