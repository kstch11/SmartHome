package house;

import resources.Electricity;

import java.util.List;

public abstract class HousePartBase implements HousePart {

    @Override
    public Electricity reportElectricity() {
        var totalElectricity = getChildren().stream()
                .map(child -> child.reportElectricity().value())
                .reduce(0, Integer::sum);
        return new Electricity(totalElectricity);
    }

    List<? extends HousePart> getChildren() {
        return List.of();
    }
}
