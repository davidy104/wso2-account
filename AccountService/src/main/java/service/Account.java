package service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private Integer accountNo;
	private int amount;

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static Builder getBuilder(Integer accountNo, int amount) {
		return new Builder(accountNo, amount);
	}

	public static class Builder {
		private Account built;

		public Builder(Integer accountNo, int amount) {
			built = new Account();
			built.accountNo = accountNo;
			built.amount = amount;
		}

		public Account build() {
			return built;
		}
	}

	@Override
	public boolean equals(Object obj) {
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(this.accountNo, ((Account) obj).accountNo)
				.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		return builder.append(this.accountNo).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append("accountNo", accountNo).append("amount", amount)
				.toString();
	}

}
