package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.mockito.Mockito;
import com.amazon.ask.quiz.handlers.EasyIntent;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TestEasyIntent {

    private EasyIntent handler;

    @Before
    public void setup() {
        handler = new EasyIntent();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

}