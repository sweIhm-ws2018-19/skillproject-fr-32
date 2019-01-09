package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.mockito.Mockito;
import com.amazon.ask.quiz.handlers.SessionEndedHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;

import java.util.HashMap;
import java.util.Map;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSessionEnded {

    private SessionEndedHandler handler;

    @Before
    public void setup() {
        handler = new SessionEndedHandler();
    }

    @Test
    public void testCtor() {
        assertEquals(handler.getClass(), SessionEndedHandler.class);
    }


    @Test
    public void canHandleTest() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }


}