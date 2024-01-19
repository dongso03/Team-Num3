package Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

public  class Customer {
	// 금액저장
	// 로또번호 저장
	private int amount ;
	private int lottoNums;
	public static Map<Integer,JLabel[]> lottoList = new HashMap<>();
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

	public int addToAmount(int value) {
		if(value < 0 || value > 10000000) {
			return this.amount += 0;
		} else {
			return this.amount += value;
		}
	}


}