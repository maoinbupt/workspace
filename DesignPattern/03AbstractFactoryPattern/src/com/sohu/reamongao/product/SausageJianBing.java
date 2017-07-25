package com.sohu.reamongao.product;

import com.sohu.reamongao.abs.AbsJianBingFactory;

public class SausageJianBing extends JianBing {
	AbsJianBingFactory ingredientFactory;
	 
	public SausageJianBing(AbsJianBingFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		egg = ingredientFactory.createEgg();
		sausage = ingredientFactory.createSausage();

	}

}
