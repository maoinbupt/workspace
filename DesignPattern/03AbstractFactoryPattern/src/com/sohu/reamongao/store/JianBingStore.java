package com.sohu.reamongao.store;

import com.sohu.reamongao.product.JianBing;

public abstract class JianBingStore {
 
	protected abstract JianBing createJianBing(String item);
 
	public JianBing order(String type) {
		JianBing jb = createJianBing(type);
		System.out.println("--- Making a " + jb.getName() + " ---");
		jb.prepare();
		jb.bake();
		jb.cut();
		jb.box();
		return jb;
	}
}
