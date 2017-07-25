package com.sohu.reamongao.factory;

import com.sohu.reamongao.abs.AbsJianBingFactory;
import com.sohu.reamongao.abs.Dough;
import com.sohu.reamongao.abs.Egg;
import com.sohu.reamongao.abs.Sausage;
import com.sohu.reamongao.product.TianJinStyleDough;
import com.sohu.reamongao.product.TianJinStyleEgg;
import com.sohu.reamongao.product.TianJinStyleSausage;

public class TianJinJianBingFactory implements AbsJianBingFactory {
	
	@Override
	public Dough createDough() {
		return new TianJinStyleDough();
	}
	@Override
	public Egg createEgg() {
		return new TianJinStyleEgg();
	}
 
	@Override
	public Sausage createSausage() {
		return new TianJinStyleSausage();
	}

}
