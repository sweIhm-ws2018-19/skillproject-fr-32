package com.amazon.ask.quiz;

import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.quiz.handlers.ExitSkillHandler;
import com.amazon.ask.quiz.handlers.HelpIntentHandler;
import com.amazon.ask.quiz.handlers.LaunchRequestHandler;
import com.amazon.ask.quiz.handlers.QuizAndStartOverIntentHandler;
import com.amazon.ask.quiz.handlers.RepeatIntentHandler;
import com.amazon.ask.quiz.handlers.SessionEndedHandler;
import com.amazon.ask.quiz.handlers.SetOnePlayerIntent;
import com.amazon.ask.quiz.handlers.SetTwoPlayerIntent;
import com.amazon.ask.quiz.handlers.GamePlayIntent;
import com.amazon.ask.quiz.handlers.GamePlayIntentTwoPlayers;

public class QuizSkillStreamHandler extends SkillStreamHandler {

    public QuizSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandlers(new LaunchRequestHandler(), new QuizAndStartOverIntentHandler(),
                             new RepeatIntentHandler(), new HelpIntentHandler(),
                             new ExitSkillHandler(), new SessionEndedHandler(), new SetOnePlayerIntent(), new SetTwoPlayerIntent(), new GamePlayIntent(), new GamePlayIntentTwoPlayers())
                .build());
    }

}
