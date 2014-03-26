package service;

import java.util.Hashtable;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AccountService.class);

	// account no list of the customers
	static Hashtable<Integer, Integer> accountStore = new Hashtable<Integer, Integer>();

	/**
	 * generates the random account no at registration
	 * 
	 * @return the random account number integer
	 */
	private int randomAccountGenerate() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(1000);
	}

	/**
	 * create a new account and store
	 * 
	 * @return accountNo
	 * 
	 */
	public int createAccount() {
		LOGGER.info("createAccount start:{} ");
		int accountNo = 0;
		// Generate the random account no
		accountNo = randomAccountGenerate();
		// create the entry in the account store
		accountStore.put(accountNo, 0);
		LOGGER.info("createAccount end:{} ", accountNo);
		return accountNo;
	}

	/**
	 * check whether the account is available
	 * 
	 * @param accountNo
	 * @return isAvailable
	 * 
	 */
	public boolean checkAccount(int accountNo) {
		LOGGER.info("checkAccount start:{} ", accountNo);
		boolean result = false;
		if (accountStore.containsKey(accountNo)) {
			result = true;
		}
		LOGGER.info("checkAccount end:{} ", result);
		return result;
	}

	/**
	 * @param accountNo
	 * @return balance
	 */
	public int checkAccountBalance(int accountNo) {
		LOGGER.info("checkAccountBalance start:{} ", accountNo);
		int balance = 0;
		if (checkAccount(accountNo)) {
			balance = accountStore.get(accountNo);
		}
		LOGGER.info("checkAccountBalance start:{} ", balance);
		return balance;
	}

	/**
	 * Increase the balance by credit amount
	 * 
	 * @param accountNo
	 * @param amount
	 * @return success
	 * 
	 */

	public String creditAccount(Account account) {
		LOGGER.info("creditAccount start:{} ", account);
		String message = "credit account created successfully";

		Integer accountNo = account.getAccountNo();
		if (accountNo == null) {
			accountNo = createAccount();
			message = message + ", and new accountNo is[" + accountNo + "]";
		} else {
			int amount = account.getAmount();
			accountStore.put(accountNo, amount);
			message = message + " for account[" + accountNo + "]";
		}
		LOGGER.info("creditAccount end:{} ", message);
		return message;
	}

	/**
	 * Decrease the balance by the debit amount
	 * 
	 * @param accountNo
	 * @param amount
	 * @return Operation successfulness
	 * 
	 */
	public boolean debitAccount(int accountNo, int amount) {
		if (checkAccount(accountNo) && (accountStore.get(accountNo) >= amount)) {
			accountStore.put(accountNo,
					(accountStore.remove(accountNo) - amount));
			return true;
		}
		return false;
	}

}