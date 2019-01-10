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

public class GamePlayIntentTwoPlayers implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PseudoTwoPlayerIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.QUIZ_STATE_TWO_PLAYER)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        int currentPlayer = (int) sessionAttributes.get(Attributes.PLAYER_NUMBER_KEY);
        int scorePlayerOne = (int) sessionAttributes.get(Attributes.SCORE_PLAYER_ONE);
        int scorePlayerTwo = (int) sessionAttributes.get(Attributes.SCORE_PLAYER_TWO);
        int playerOneQuestionNumber = (int) sessionAttributes.get(Attributes.CURRENT_QUESTION_OF_PLAYER_ONE);
        int playerTwoQuestionNumber = (int) sessionAttributes.get(Attributes.CURRENT_QUESTION_OF_PLAYER_TWO);
        int totalcounter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);

        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        String responseText = "";
        final String frb = " Fragen richtig beantwortet. ";
        final String von = " von ";

        if((totalcounter + 1) > 1) //spiel ist bereits nach der ersten frage...
        {
            String rightmovie = ((String) sessionAttributes.get(Attributes.RIGHT_MOVIE)).trim().toLowerCase();

            Slot movieSlot = slots.get("Movies");
            String said = movieSlot.getValue();

            if(said.trim().equalsIgnoreCase(rightmovie))
            {




                if(currentPlayer == 1)
                {
                    scorePlayerOne++;
                    responseText += said + " ist richtig! Du hast " + (scorePlayerOne) + von + (playerOneQuestionNumber) + frb;
                    playerOneQuestionNumber++;
                    sessionAttributes.put(Attributes.SCORE_PLAYER_ONE, scorePlayerOne);
                    sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_ONE, playerOneQuestionNumber);
                    sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 2);
                } else
                {
                    scorePlayerTwo++;
                    responseText += said + " ist richtig! Du hast " + (scorePlayerTwo) + von + (playerTwoQuestionNumber) + frb;
                    playerTwoQuestionNumber++;
                    sessionAttributes.put(Attributes.SCORE_PLAYER_TWO, scorePlayerTwo);
                    sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_TWO, playerTwoQuestionNumber);
                    sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 1);
                }

            } else //falsch
            {

                if(currentPlayer == 1)
                {
                    responseText += said + " ist leider falsch! Du hast " + (scorePlayerOne) + von + (playerOneQuestionNumber) + frb;
                    sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 2);
                    playerOneQuestionNumber++;
                    sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_ONE, playerOneQuestionNumber);
                } else
                {
                    responseText += said + " ist leider falsch! Du hast " + (scorePlayerTwo) + von + (playerTwoQuestionNumber) + frb;
                    sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 1);
                    playerTwoQuestionNumber++;
                    sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_TWO, playerTwoQuestionNumber);
                }

            }

            if((totalcounter + 1) > 10) {

                final String playerWon;

                if(scorePlayerOne > scorePlayerTwo)
                {
                    playerWon =  "Herzlichen Glückwunsch Spieler 1. Du hast gewonnen! ";
                } else if(scorePlayerOne == scorePlayerTwo)
                {
                    playerWon =  " Unentschieden! Was für ein Kopf-an-Kopf Rennen. ";
                } else
                {
                    playerWon =  "Herzlichen Glückwunsch Spieler 2. Du hast gewonnen! ";
                }

                responseText += "Das war's, das Spiel ist vorbei. Ihr habt euch toll geschlagen. Spieler 1, du hast " + scorePlayerOne + " Punkte erlangt. Spieler 2, du hast " + scorePlayerTwo + " Punkte erlangt." + playerWon + "Um nochmal zu Spielen sage einfach - Alexa - öffne Magisches Zitate Raten. Bis dann!";

                return input.getResponseBuilder()
                        .withSpeech(responseText)
                        .withShouldEndSession(true)
                        .build();
            }

        }

        currentPlayer = (int) sessionAttributes.get(Attributes.PLAYER_NUMBER_KEY);

        responseText += "Spieler Nummer " + currentPlayer + " - ";


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

        responseText += "Das " + (totalcounter + 1) + "te Zitat lautet. " + quote + " ist es - " + movies.get(0) + " - " + movies.get(1) + " - oder - " + movies.get(2) + ".";

        totalcounter++;
        sessionAttributes.put(Attributes.RIGHT_MOVIE, movie);
        sessionAttributes.put(Attributes.COUNTER_KEY, totalcounter);
        sessionAttributes.put(Attributes.REPEAT_QUESTION, responseText);

        return input.getResponseBuilder()
                .withSpeech(responseText)
                .withShouldEndSession(false)
                .build();


    }



}

