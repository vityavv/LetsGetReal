public class RationalNumber extends RealNumber {
	private int numerator, denominator;

	public RationalNumber(int nume, int deno) {
		super(0.0);
		numerator = nume;
		denominator = deno;
		if (numerator != 0) reduce();
	}
	public double getValue() {
		return (double) numerator / denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public RationalNumber reciprocal() {
		return new RationalNumber(denominator, numerator);
	}
	public boolean equals(RationalNumber other) {
		return numerator == other.getNumerator() && denominator == other.getDenominator();
	}
	public String toString() {
		if (numerator == 0) return "0";
		if (denominator == 1) return ""+numerator;
		return "" + numerator + "/" + denominator;
	}
	private static int gcd(int a, int b) {
		while (true) {
			if (a < b) {
				int temp = a;
				a = b;
				b = temp;
			}
			int r = a % b;
			if (r == 0) return b;
			a = b;
			b = r;
		}
	}
	private void reduce() {
		//boolean negative = numerator < 0 ^ denominator < 0; // future me: ^ is xor
		boolean negative = (numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0);
		int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
		numerator = (negative ? -1 : 1) * Math.abs(numerator) / gcd;
		denominator = Math.abs(denominator) / gcd;
	}
	public RationalNumber multiply(RationalNumber other) {
		return new RationalNumber(numerator * other.getNumerator(), denominator * other.getDenominator());
	}
	public RationalNumber divide(RationalNumber other) {
		return new RationalNumber(numerator * other.getDenominator(), denominator * other.getNumerator());
	}
	public RationalNumber add(RationalNumber other) {
		return new RationalNumber(
			numerator * other.getDenominator() + other.getNumerator() * denominator,
			denominator * other.getDenominator()
		);
	}
	public RationalNumber subtract(RationalNumber other) {
		return new RationalNumber(
			numerator * other.getDenominator() - other.getNumerator() * denominator,
			denominator * other.getDenominator()
		);
	}
}
