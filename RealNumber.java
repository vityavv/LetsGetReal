public class RealNumber {
	private double value;
	public RealNumber(double v) {
		value = v;
	}
	public double getValue() {
		return value;
	}
	public RealNumber add(RealNumber other) {
		return new RealNumber(value + other.getValue());
	}
	public RealNumber multiply(RealNumber other) {
		return new RealNumber(value * other.getValue());
	}
	public RealNumber divide(RealNumber other) {
		return new RealNumber(value / other.getValue());
	}
	public RealNumber subtract(RealNumber other) {
		return new RealNumber(value - other.getValue());
	}
	public boolean equals(RealNumber other) {
		if (value == 0) return other.getValue() == 0;
		double diff = Math.abs(other.getValue() - value);
		if (diff == 0 || (diff / value <= 0.00001 && diff / other.getValue() <= 0.00001)) return true;
		return false;
	}
	public String toString() {
		return ""+getValue();
	}
}
