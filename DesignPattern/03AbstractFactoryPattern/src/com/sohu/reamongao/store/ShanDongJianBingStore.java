package com.sohu.reamongao.store;

import com.sohu.reamongao.abs.AbsJianBingFactory;
import com.sohu.reamongao.factory.ShanDongJianBingFactory;
import com.sohu.reamongao.product.EggJianBing;
import com.sohu.reamongao.product.JianBing;
import com.sohu.reamongao.product.SausageJianBing;

public class ShanDongJianBingStore extends JianBingStore {

	@Override
	protected JianBing createJianBing(String item) {
		JianBing jb = null;
		AbsJianBingFactory ingredientFactory = 
			new ShanDongJianBingFactory();
 
		if (item.equals("egg")) {
  
			jb = new EggJianBing(ingredientFactory);
			jb.setName("ShanDong Style Egg JianBing");
  
		} else if (item.equals("sausage")) {

			jb = new SausageJianBing(ingredientFactory);
			jb.setName("ShanDong Style Sausage JianBing");
 
		} 
		return jb;
	}

}
