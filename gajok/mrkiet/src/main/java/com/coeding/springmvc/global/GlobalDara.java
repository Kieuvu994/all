package com.coeding.springmvc.global;

import java.util.ArrayList;
import java.util.List;


import com.coeding.springmvc.entity.Productz;

public class GlobalDara {

	public static List<Productz> cart;
	static {
		cart = new ArrayList<Productz>();
	}
}
