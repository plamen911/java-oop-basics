package org.lynxlake.inheritance.mordorsCrueltyPlan.factories;

import org.lynxlake.inheritance.mordorsCrueltyPlan.models.Mood;
import org.lynxlake.inheritance.mordorsCrueltyPlan.models.mood.Angry;
import org.lynxlake.inheritance.mordorsCrueltyPlan.models.mood.Happy;
import org.lynxlake.inheritance.mordorsCrueltyPlan.models.mood.JavaScript;
import org.lynxlake.inheritance.mordorsCrueltyPlan.models.mood.Sad;

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
