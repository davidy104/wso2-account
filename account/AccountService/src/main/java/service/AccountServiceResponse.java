package service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AccountServiceResponse implements Serializable {

	private static final long serialVersionUID = 6057272398088956483L;
	private boolean operationResult;
	private String message;

	public boolean isOperationResult() {
		return operationResult;
	}

	public void setOperationResult(boolean operationResult) {
		this.operationResult = operationResult;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void update(boolean operationResult, String message) {
		this.operationResult = operationResult;
		this.message = message;
	}

	public static Builder getBuilder(boolean operationResult, String message) {
		return new Builder(operationResult, message);
	}

	public static class Builder {
		private AccountServiceResponse built;

		public Builder(boolean operationResult, String message) {
			built = new AccountServiceResponse();
			built.operationResult = operationResult;
			built.message = message;
		}

		public AccountServiceResponse build() {
			return built;
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append("operationResult", operationResult)
				.append("message", message).toString();
	}
}
