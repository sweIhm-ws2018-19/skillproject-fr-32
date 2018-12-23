package com.amazon.ask.test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import com.amazon.ask.quiz.model.Attributes;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;


public class TestAttributes {

    @Test
    public void doTestAttributes() {

        String a = "state";
        String b = "quizitem";
        String c = "quizscore";
        String d = "quizscorefirst";
        String e = "quizscoresecond";
        String f = "playernumber";
        String g = "quizproperty";
        String h = "counter";
        String i = "counterplayerone";
        String j = "counterplayertwo";
        String k = "response";
        String l = "rightmovie";

        String m = "_START";
        String n = "_SELECT";
        String o = "_QUIZONE";
        String p = "_QUIZTWO";
        String q = "_SAYGO";


        assertEquals(a, Attributes.STATE_KEY);
        assertEquals(b, Attributes.QUIZ_ITEM_KEY);
        assertEquals(c, Attributes.QUIZ_SCORE_KEY);
        assertEquals(d, Attributes.QUIZ_SCORE_FIRST);
        assertEquals(e, Attributes.QUIZ_SCORE_SECOND);
        assertEquals(f, Attributes.PLAYER_NUMBER_KEY);
        assertEquals(g, Attributes.QUIZ_PROPERTY_KEY);
        assertEquals(h, Attributes.COUNTER_KEY);
        assertEquals(i, Attributes.COUNTER_PLAYER_ONE);
        assertEquals(j, Attributes.COUNTER_PLAYER_TWO);
        assertEquals(k, Attributes.RESPONSE_KEY);
        assertEquals(l, Attributes.RIGHT_MOVIE);

        assertEquals(m, Attributes.START_STATE);
        assertEquals(n, Attributes.SELECT_STATE);
        assertEquals(o, Attributes.QUIZ_STATE_ONE_PLAYER);
        assertEquals(p, Attributes.QUIZ_STATE_TWO_PLAYER);
        assertEquals(q, Attributes.SAY_GO_STATE);

    }

}