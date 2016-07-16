package com.bam.mathquiz;

import java.util.Random;

public final class QuestionGenerator {

    public static int[] generateQuestionSet(){
        Random randomGenerator = new Random();
        int addFirst = randomGenerator.nextInt(100) + 1;
        int addSecond = randomGenerator.nextInt(100) + 1;
        int answer = addFirst + addSecond;

        int incorrectFirst = answer + randomGenerator.nextInt(randomGenerator.nextInt(answer) + 1) + 1;
        int incorrectSecond = answer + randomGenerator.nextInt(randomGenerator.nextInt(answer) + 1) + 1;

        return new int[] {addFirst, addSecond, answer, incorrectFirst, incorrectSecond};
    }
}
