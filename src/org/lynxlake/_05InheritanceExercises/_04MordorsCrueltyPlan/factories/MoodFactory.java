package org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.factories;

import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models.Mood;
import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models.mood.Angry;
import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models.mood.Happy;
import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models.mood.JavaScript;
import org.lynxlake._05InheritanceExercises._04MordorsCrueltyPlan.models.mood.Sad;

public class MoodFactory {
    public static Mood getMood(Integer happinessPoint) {
        if (happinessPoint < -5) {
            return new Angry();
        } else if (happinessPoint >= -5 && happinessPoint < 0) {
            return new Sad();
        } else if (happinessPoint >= 0 && happinessPoint <= 15) {
            return new Happy();
        } else {
            return new JavaScript();
        }
    }
}
