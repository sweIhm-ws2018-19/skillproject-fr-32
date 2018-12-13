package com.amazon.ask.quiz.model;

public final class Attributes {

    private Attributes()
    {}

    public static final String STATE_KEY = "state";
    public static final String QUIZ_ITEM_KEY = "quizitem";
    public static final String QUIZ_SCORE_KEY = "quizscore";
    public static final String QUIZ_SCORE_FIRST = "quizscorefirst";
    public static final String QUIZ_SCORE_SECOND = "quizscoresecond";
    public static final String PLAYER_NUMBER_KEY  = "playernumber";
    public static final String QUIZ_PROPERTY_KEY = "quizproperty";
    public static final String COUNTER_KEY = "counter";
    public static final String COUNTER_PLAYER_ONE = "counterplayerone";
    public static final String COUNTER_PLAYER_TWO = "counterplayertwo";
    public static final String RESPONSE_KEY = "response";
    public static final String RIGHT_MOVIE = "rightmovie";
    public static final String PLAYERCOUNTER = "numbersofplayers";

    public static final String SCORE_PLAYER_ONE = "scoreofplayerone";
    public static final String SCORE_PLAYER_TWO = "scoreofplayertwo";
    public static final String CURRENT_QUESTION_OF_PLAYER_ONE = "currentquestionplayerone";
    public static final String CURRENT_QUESTION_OF_PLAYER_TWO = "currentquestionplayertwo";
    public static final String REPEAT_QUESTION = "repeatquestion";

    public static final String START_STATE = "_START";
    public static final String SELECT_STATE = "_SELECT";
    public static final String QUIZ_STATE_ONE_PLAYER = "_QUIZONE";
    public static final String QUIZ_STATE_TWO_PLAYER = "_QUIZTWO";
    public static final String QUIZ_STATE_SELECT_DIFFICULTY = "_DIFFICULTY";
    public static final String SAY_GO_STATE = "_SAYGO";
    public static final String REPLAY_STATE = "_REPLAYSTATE";
}
