package day6.part2;

import java.util.Objects;
import java.util.Optional;

public class Planet {
    String name;
    Optional<Planet> orbit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);
    }


    Planet(String name) {
        this.name = name;
        orbit = Optional.empty();
    }

}
