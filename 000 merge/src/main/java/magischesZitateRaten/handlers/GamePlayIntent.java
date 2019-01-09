package com.amazon.ask.quiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.util.QuestionPack;
import com.amazon.ask.quiz.util.QuestionDatabase;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class GamePlayIntent implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PseudoOnePlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_ONE_PLAYER) ));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        int score = (int) sessionAttributes.get(Attributes.QUIZ_SCORE_KEY);
        int counter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);

        String responseText = "";

        if((counter + 1) > 1)
        {
            String rightmovie = ((String) sessionAttributes.get(Attributes.RIGHT_MOVIE)).trim().toLowerCase();

            Slot movieSlot = slots.get("Movies");
            String said = movieSlot.getValue();

            if(said.trim().equalsIgnoreCase(rightmovie))
            {
                score++;
                responseText += said + " ist richtig! Du hast " + (score) + " von " + (counter) + " Fragen richtig beantwortet. ";
                sessionAttributes.put(Attributes.QUIZ_SCORE_KEY, counter);
            } else
            {
                responseText += said + " ist leider falsch! Du hast " + (score) + " von " + (counter) + " Fragen richtig beantwortet. ";
            }

            if((counter + 1) > 5) {

                responseText += "Das war's, das Spiel ist vorbei. Du hast dich toll geschlagen. Das hat Spaß gemacht! Um nochmal zu Spielen sage einfach Alexa öffne Magisches Zitate Raten. Bis dann!";

                return input.getResponseBuilder()
                        .withSpeech(responseText)
                        .withShouldEndSession(true)
                        .build();
            }
        }

        QuestionPack qp = QuestionDatabase.generateQuestionPack();

        String quote = qp.getQuote();
        String movie = qp.getMovie();
        String fakeOne = qp.getFakeMovieOne();
        String fakeTwo = qp.getFakeMovieTwo();

        ArrayList<String> movies = new ArrayList<>();

        movies.add(movie);
        movies.add(fakeOne);
        movies.add(fakeTwo);

        Collections.shuffle(movies);

        responseText += "Das " + (counter + 1) + "te Zitat lautet. " + quote + " ist es - " + movies.get(0) + " - " + movies.get(1) + " - oder - " + movies.get(2) + ".";

        counter++;
        sessionAttributes.put(Attributes.COUNTER_KEY, counter);
        sessionAttributes.put(Attributes.RIGHT_MOVIE, movie);
        sessionAttributes.put(Attributes.REPEAT_QUESTION, responseText);

        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();

    }



}
