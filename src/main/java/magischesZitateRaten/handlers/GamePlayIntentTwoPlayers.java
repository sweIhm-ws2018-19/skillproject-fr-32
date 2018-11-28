package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;
import com.amazon.ask.quiz.model.Constants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class GamePlayIntentTwoPlayers implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PseudoTwoPlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_TWO_PLAYER)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        QuestionDatabase.initialize();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        int playerNumber = (int) sessionAttributes.get(Attributes.PLAYER_NUMBER_KEY);
        int score_one = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_FIRST);
        int score_two = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_SECOND);
        int counter_one = (int) sessionAttributes.get(Attributes.COUNTER_PLAYER_ONE);
        int counter_two = (int) sessionAttributes.get(Attributes.COUNTER_PLAYER_TWO);
        int totalcounter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);
        int counter = 0;
        String reversePlayerString = "";

        String responseText = "";


        if(playerNumber == 1)
        {
            sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 2);
            reversePlayerString = "Spieler 2 ";
        }

        if(playerNumber == 2)
        {
            sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 1);
            reversePlayerString = "Spieler 1 ";
        }

        if(totalcounter == 4 ||totalcounter == 6 || totalcounter == 8 || totalcounter == 10)
        {
            score_one++;
            sessionAttributes.put(Attributes.QUIZ_SCORE_FIRST, score_one);
        }

        if(totalcounter > 1)
        {
            String rightmovie = (String) sessionAttributes.get(Attributes.RIGHT_MOVIE);
            responseText += rightmovie + " ist richtig! " + reversePlayerString + "  hat " + (score_one) + " von " + (score_one) + " Fragen richtig beantwortet. ";
        }

        if(playerNumber == 1)
        {
            responseText += "Spieler Nummer 1 ";
        }

        if(playerNumber == 2)
        {
            responseText += "Spieler Nummer 2 ";
        }

        QuestionPack qp = QuestionDatabase.generateQuestionPack();

        String Quote = qp.getQuote();
        String Movie = qp.getMovie();
        String fakeOne = qp.getFakeMovieOne();
        String fakeTwo = qp.getFakeMovieTwo();

        responseText += "Das " + totalcounter + "te Zitat lautet gefolgt. " + Quote + " M?glichkeit 1 " + fakeOne + ". M?glichkeit 2 " + Movie + ". M?glichkeit 3 " + fakeTwo + ".";
        responseText += " Dies ist eine Beta. Antworte mit Weiter um fortzufahren.";

        sessionAttributes.put(Attributes.COUNTER_KEY, counter);
        sessionAttributes.put(Attributes.RIGHT_MOVIE, Movie);

        totalcounter++;

        sessionAttributes.put(Attributes.COUNTER_KEY, totalcounter);

        if((totalcounter - 1) < 10) {
            return input.getResponseBuilder()
                    .withSpeech(responseText)
                    .withShouldEndSession(false)
                    .build();
        } else
        {
            responseText += " 10 Fragen wurden gestellt. Das Spiel ist somit beendet. Ich freue mich auf ein baldiges wiedersehen bei Magisches Zitate Raten.";
            return input.getResponseBuilder()
                    .withSpeech(responseText)
                    .withShouldEndSession(true)
                    .build();
        }

    }



}
