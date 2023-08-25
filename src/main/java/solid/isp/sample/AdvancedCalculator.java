package solid.isp.sample;

public class AdvancedCalculator implements Operations {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }

    @Override
    public Double sine(Double angle) {
        return Math.sin(angle);
    }

    @Override
    public Double cosine(Double angle) {
        return Math.cos(angle);
    }

}
