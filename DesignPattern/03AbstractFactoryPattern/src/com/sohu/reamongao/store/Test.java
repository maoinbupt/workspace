package com.sohu.reamongao.store;

import com.sohu.reamongao.product.JianBing;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JianBingStore sdStore = new ShanDongJianBingStore();
		JianBingStore tjStore = new TianJinJianBingStore();	
		
		
		JianBing jb = sdStore.order("egg");
		System.out.println("ClientA ordered a " + jb + "\n");
		
		jb = tjStore.order("egg");
		System.out.println("ClientB ordered a " + jb + "\n");
		
		jb = sdStore.order("sausage");
		System.out.println("ClientC ordered a " + jb + "\n");
 
		jb = tjStore.order("sausage");
		System.out.println("ClientD ordered a " + jb + "\n");
 
	}
	
	
}
