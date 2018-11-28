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

public class GamePlayIntent implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PseudoOnePlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_ONE_PLAYER) ));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        QuestionDatabase.initialize();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        int score = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_KEY);
        int counter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);

        String responseText = "";

        if(counter > 1)
        {
            String rightmovie = (String) sessionAttributes.get(Attributes.RIGHT_MOVIE);
            responseText += rightmovie + " ist richtig! Sie haben " + (counter - 1) + " von " + (counter - 1) + " Fragen richtig beantwortet. ";
        }

        QuestionPack qp = QuestionDatabase.generateQuestionPack();

        String Quote = qp.getQuote();
        String Movie = qp.getMovie();
        String fakeOne = qp.getFakeMovieOne();
        String fakeTwo = qp.getFakeMovieTwo();

        responseText += "Das " + counter + "te Zitat lautet gefolgt. " + Quote + " Möglichkeit 1 " + fakeOne + ". Möglichkeit 2 " + Movie + ". Möglichkeit 3 " + fakeTwo + ".";
        responseText += " Dies ist eine Beta. Antworte mit Test um fortzufahren.";

        counter++;

        sessionAttributes.put(Attributes.COUNTER_KEY, counter);
        sessionAttributes.put(Attributes.RIGHT_MOVIE, Movie);

        if((counter - 1) < 10) {
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
