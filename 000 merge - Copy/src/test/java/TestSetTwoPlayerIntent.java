package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.mockito.Mockito;
import com.amazon.ask.quiz.handlers.SetTwoPlayerIntent;
import com.amazon.ask.model.Response;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
public class TestSetTwoPlayerIntent {

    private SetTwoPlayerIntent handler;

    @Before
    public void setup() {
        handler = new SetTwoPlayerIntent();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test(expected = NullPointerException.class)
    public void testHandle() {
        final HandlerInput mockInput = TestUtil.mockHandlerInput(null, null, null, null);
        final Optional<Response> res = handler.handle(mockInput);

        assertTrue(res.isPresent());
        final Response response = res.get();
        assertTrue(response.getOutputSpeech().toString().length() >= 0);
        assertTrue(response.getReprompt().toString().length() >= 0);
    }

}