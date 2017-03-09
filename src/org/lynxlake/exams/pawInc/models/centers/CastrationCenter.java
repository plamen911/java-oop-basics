package org.lynxlake.exams.pawInc.models.centers;

import org.lynxlake.exams.pawInc.models.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CastrationCenter extends Center {

    public CastrationCenter(String name) {
        super(name);
    }

    public List<Animal> castrate() {
        List<Animal> castrated = new ArrayList<>(super.getAnimals());
        super.removeAnimals(castrated);
        return castrated;
    }
}
