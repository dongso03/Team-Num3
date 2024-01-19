package Lotto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public  class Customer {
	// 금액저장
	// 로또번호 저장
	private int amount ;
	private int lottoNums;
	public static List<List<Integer>> lottoList = new ArrayList<>();
	public static int value;

	public Customer(int amount, int lottoNums) {
		super();
		this.amount = amount;
		this.lottoNums = lottoNums;
	}



	public Customer() {
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLottoNums() {
		return lottoNums;
	}

	public void setLottoNums(int lottoNums) {
		this.lottoNums = lottoNums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + lottoNums;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (amount != other.amount)
			return false;
		if (lottoNums != other.lottoNums)
			return false;
		return true;
	}



}