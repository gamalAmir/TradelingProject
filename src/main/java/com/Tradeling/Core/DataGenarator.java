package com.Tradeling.Core;

import java.util.Random;

public class DataGenarator {
	
	public static int generateRandomNumber(int n) {
	    int m = (int) Math.pow(10, n - 1);
	    return m + new Random().nextInt(9 * m);
	}
	
	public static String generateRandomNumberAsString(int n) {
	    int m = (int) Math.pow(10, n - 1);
	    int num = m + new Random().nextInt(9 * m);
	    String num_ = String.valueOf(num);
	    return num_;
	}
	


}
