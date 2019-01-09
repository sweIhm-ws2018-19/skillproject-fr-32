package com.amazon.ask.quiz.model;

import com.amazon.ask.quiz.util.QuestionDatabase;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;

import java.util.Map;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class MethodUtils {

    private MethodUtils()
    {}

    public static String startGame(int difficulty, int playerNumber, HandlerInput input)
    {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        QuestionDatabase.setDifficulty(difficulty);

        final String ret;

        if(playerNumber == 1)
        {
            sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_ONE_PLAYER);
            sessionAttributes.put(Attributes.COUNTER_KEY, 0);
            sessionAttributes.put(Attributes.QUIZ_SCORE_KEY, 0);
            ret = " Sage los um mit dem Spiel zu beginnen.";
        } else
        {
            sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE_TWO_PLAYER);
            sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 1);
            sessionAttributes.put(Attributes.SCORE_PLAYER_ONE, 0);
            sessionAttributes.put(Attributes.SCORE_PLAYER_TWO, 0);
            sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_ONE, 1);
            sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_TWO, 1);
            sessionAttributes.put(Attributes.COUNTER_KEY, 0);
            ret = " Bitte antworte im 2 Spieler Modus immer mit - Es ist - wie zum Beispiel - Es ist König der Löwen - Sage aufgehts um mit dem Spiel zu beginnen.";
        }

        return ret;
    }

}
