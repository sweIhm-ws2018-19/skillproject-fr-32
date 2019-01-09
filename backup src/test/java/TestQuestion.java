package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.quiz.util.Question;



import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestQuestion {

    @Test
    public void doTestQuestion() {

        Question q = new Question("one", "two");

        String testOne = "one";

        String testTwo = "two";

        // assert statements
        assertEquals(q.getMovie(), testOne);

        assertEquals(q.getQuote(), testTwo);
    }

}