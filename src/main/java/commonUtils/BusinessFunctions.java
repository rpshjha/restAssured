package commonUtils;

public class BusinessFunctions {

	/**
	 * @param basePrice
	 * @param discount
	 * @param discountType
	 * @return {@link Float} effectivePrice
	 */
	public static double GetPriceAfterDiscount(double basePrice, double discount, String discountType) {

		if (discount != 0 && discount < 0)
			discount = Math.abs(discount);

		if (discountType.equals("P"))
			basePrice -= ((basePrice / 100) * discount);
		else if (discountType.equals("F"))
			basePrice -= discount;

		return Math.round(basePrice * 100) / 100.00;
	}

}
