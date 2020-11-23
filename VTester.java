public class VTester {
	public static void main(String[] args) {
		RealNumber five = new RealNumber(5.0);
		RealNumber otherFive = new RealNumber(5.0);
		RealNumber ten = new RealNumber(10.0);
		RealNumber four = new RealNumber(4.0);
		RealNumber six = new RealNumber(6.0);
		test("RealNumber.equals", five.equals(otherFive));
		test("!RealNumber.equals", !five.equals(four));
		test("RealNumber.add", six.add(four).equals(ten));
		test("RealNumber.multiply", five.multiply(otherFive).equals(new RealNumber(25.0)));
		test("RealNumber.divide", five.divide(otherFive).equals(new RealNumber(1.0)));
		test("RealNumber.subtract", ten.subtract(five).equals(otherFive));

		//Decimal number tests!!!
		RealNumber bitMoreThanFive = new RealNumber(5.0000001);
		RealNumber bitLessThanFive = new RealNumber(4.9999999);
		test("RealNumber.equals with small variance", bitMoreThanFive.equals(bitLessThanFive));

		RationalNumber twoThirds = new RationalNumber(2, 3);
		RationalNumber fourSixths = new RationalNumber(4, 6);
		RationalNumber oneQuarter = new RationalNumber(1, 4);
		test("RationalNumber.getNumerator", twoThirds.getNumerator() == 2);
		test("RationalNumber.getDenominator", twoThirds.getDenominator() == 3);
		test("RationalNumber.equals", twoThirds.equals(fourSixths));
		test("RationalNumber.reciprocal", twoThirds.reciprocal().equals(new RationalNumber(3, 2)));
		test("RationalNumber.multiply", twoThirds.multiply(oneQuarter).equals(new RationalNumber(1, 6)));
		test("RationalNumber.divide", twoThirds.divide(oneQuarter).equals(new RationalNumber(8, 3)));
		test("RationalNumber.add", twoThirds.add(oneQuarter).equals(new RationalNumber(11, 12)));
		test("RationalNumber.subtract", twoThirds.subtract(oneQuarter).equals(new RationalNumber(5, 12)));
		test("RationalNumber.toString", fourSixths.toString().equals("2/3"));

		test("RationalNumber.toString", new RationalNumber(0, 44).toString().equals("0"));
		test("RationalNumber.toString", new RationalNumber(44, 1).toString().equals("44"));
	}
	public static void test(String name, boolean worked) {
		if (!worked) {
			System.out.println("\033[1;91m" + name + " failed \033[0m");
		} else {
			System.out.println("\033[92m" + name + " passed \033[0m");
		}
	}
}
