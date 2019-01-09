package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.mockito.Mockito;
import com.amazon.ask.quiz.handlers.GamePlayIntentTwoPlayers;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.model.Response;
import java.util.Optional;
import com.amazon.ask.quiz.util.QuestionDatabase;

import java.util.HashMap;
import java.util.Map;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGamePlayIntentTwoPlayers {

    private GamePlayIntentTwoPlayers handler;

    @Before
    public void setup() {
        handler = new GamePlayIntentTwoPlayers();
    }

    @Test
    public void testCtor() {
        assertEquals(handler.getClass(), GamePlayIntentTwoPlayers.class);
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void nullHandleTest(){
        assertThrows(NullPointerException.class, () -> handler.handle(null));
    }

    @Test
    public void handleSlotNotNullTest(){
        final Map<String, Object> sessionAttributes = new HashMap<>();
        final Map<String, Object> persistentAttributes = new HashMap<>();
        final Map<String, String> slots = new HashMap<>();
        slots.put("Movies", "Mulan");

        QuestionDatabase.initialize();

        sessionAttributes.put(Attributes.PLAYER_NUMBER_KEY, 0);
        sessionAttributes.put(Attributes.SCORE_PLAYER_ONE, 0);
        sessionAttributes.put(Attributes.SCORE_PLAYER_TWO, 0);
        sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_ONE, 0);
        sessionAttributes.put(Attributes.CURRENT_QUESTION_OF_PLAYER_TWO, 0);
        sessionAttributes.put(Attributes.COUNTER_KEY, 0);

        final HandlerInput inputMock = TestUtil.mockHandlerInput(slots, sessionAttributes, persistentAttributes, null);
        final Optional<Response> res = handler.handle(inputMock);


        assertTrue(res.isPresent());
        final Response response = res.get();

        assertFalse(response.getShouldEndSession());
        assertNotNull(response.getOutputSpeech());
        assertTrue(response.getOutputSpeech().toString().contains("Das"));
    }


}