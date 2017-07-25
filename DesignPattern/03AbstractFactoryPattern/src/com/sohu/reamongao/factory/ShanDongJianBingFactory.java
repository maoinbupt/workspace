package com.sohu.reamongao.factory;

import com.sohu.reamongao.abs.AbsJianBingFactory;
import com.sohu.reamongao.abs.Dough;
import com.sohu.reamongao.abs.Egg;
import com.sohu.reamongao.abs.Sausage;
import com.sohu.reamongao.product.ShanDongStyleDough;
import com.sohu.reamongao.product.ShanDongStyleEgg;
import com.sohu.reamongao.product.ShanDongStyleSausage;

public class ShanDongJianBingFactory implements AbsJianBingFactory {
	
	@Override
	public Dough createDough() {
		return new ShanDongStyleDough();
	}
	@Override
	public Egg createEgg() {
		return new ShanDongStyleEgg();
	}
 
	@Override
	public Sausage createSausage() {
		return new ShanDongStyleSausage();
	}

}
