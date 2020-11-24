public abstract class Number {
	boolean equals(Number other) {
		if (getValue() == 0) return other.getValue() == 0;
		double diff = Math.abs(other.getValue() - getValue());
		if (diff == 0 || (diff / getValue() <= 0.00001 && diff / other.getValue() <= 0.00001)) return true;
		return false;
	}

	public int compareTo(Number other) {
		if (equals(other)) return 0;
		else if (getValue() < other.getValue()) return -1;
		else return 1;
	}

	public abstract double getValue();
}
