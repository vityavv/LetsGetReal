public class RationalNumber extends RealNumber {
	private int numerator, denominator;

	public RationalNumber(int nume, int deno) {
		super(0.0);
		numerator = nume;
		denominator = deno;
		reduce();
	}
	public double getValue() {
		return numerator / denominator;
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
		//TODO: ask if this is necessary:
		//if (numerator == 0) return "0";
		return numerator + "/" + denominator;
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
		int gcd = gcd(numerator, denominator);
		numerator = numerator / gcd;
		denominator = denominator / gcd;
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
