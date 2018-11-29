package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class GamePlayIntentTwoPlayers implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PseudoTwoPlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_TWO_PLAYER)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {



        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        int playerNumber = (int) sessionAttributes.get(Attributes.PLAYER_NUMBER_KEY);
        int scoreOne = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_FIRST);
        //int score_two = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_SECOND)
        // int counter_one = (int) sessionAttributes.get(Attributes.COUNTER_PLAYER_ONE)
        //int counter_two = (int) sessionAttributes.get(Attributes.COUNTER_PLAYER_TWO)
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
            scoreOne++;
            sessionAttributes.put(Attributes.QUIZ_SCORE_FIRST, scoreOne);
        }

        if(totalcounter > 1)
        {
            String rightmovie = (String) sessionAttributes.get(Attributes.RIGHT_MOVIE);
            responseText += rightmovie + " ist richtig! " + reversePlayerString + "  hat " + (scoreOne) + " von " + (scoreOne) + " Fragen richtig beantwortet. ";

            if((totalcounter) > 10) {

                responseText += " 10 Fragen wurden gestellt. Das Spiel ist somit beendet. Ich freue mich auf ein baldiges wiedersehen bei Magisches Zitate Raten.";

                return input.getResponseBuilder()
                        .withSpeech(responseText)
                        .withShouldEndSession(true)
                        .build();
            }

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

        String quote = qp.getQuote();
        String movie = qp.getMovie();
        String fakeOne = qp.getFakeMovieOne();
        String fakeTwo = qp.getFakeMovieTwo();

        responseText += "Das " + totalcounter + "te Zitat lautet gefolgt. " + quote + " Möglichkeit 1 " + fakeOne + ". Möglichkeit 2 " + movie + ". Möglichkeit 3 " + fakeTwo + ".";
        responseText += " Dies ist eine Beta. Antworte mit Weiter um fortzufahren.";

        sessionAttributes.put(Attributes.COUNTER_KEY, counter);
        sessionAttributes.put(Attributes.RIGHT_MOVIE, movie);

        totalcounter++;

        sessionAttributes.put(Attributes.COUNTER_KEY, totalcounter);

        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();


    }



}
