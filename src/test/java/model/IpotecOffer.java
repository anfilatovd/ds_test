package model;

public class IpotecOffer {
	public int monthlyPayment;

	public String rate;

	public int creditSum;

	public int creditTerm;

	@Override
	public String toString() {
		return String.format("MonthlyPayment: %s, Rate: %s, Sum: %s, Term: %s", monthlyPayment, rate, creditSum,
				creditTerm);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof IpotecOffer)) {
			return false;
		}
		
		IpotecOffer another = (IpotecOffer) obj;
		return this.monthlyPayment == another.monthlyPayment && 
				this.rate.equalsIgnoreCase(another.rate) && 
				this.creditSum == another.creditSum && 
				this.creditTerm == another.creditTerm;
	}
}
