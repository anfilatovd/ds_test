package model;

public class IpotecParams {
	public int estateCost;

	public int initialFee;

	public int creditTerm;

	@Override
	public String toString() {
		return String.format("EstateCost: %s, InitialFee: %s, Term: %s", estateCost, initialFee, creditTerm);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof IpotecParams)) {
			return false;
		}
		IpotecParams another = (IpotecParams) obj;
		return this.estateCost == another.estateCost && this.initialFee == another.initialFee
				&& this.creditTerm == another.creditTerm;
	}
}
