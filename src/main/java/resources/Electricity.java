package resources;

public record Electricity(int value) {
    public Electricity {
        if (value < 0) {
            throw new IllegalArgumentException("Electricity value is below 0.");
        }
    }
}
