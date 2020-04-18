package com.takeout.tool;

import java.text.DecimalFormat;

public class Num {

	public static String formatDouble(double num) {
		DecimalFormat doubleFormat = new DecimalFormat("###################.###########");
		return doubleFormat.format(num);
	}
}
