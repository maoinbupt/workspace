package com.sohu.reamongao.store;

import com.sohu.reamongao.abs.AbsJianBingFactory;
import com.sohu.reamongao.factory.TianJinJianBingFactory;
import com.sohu.reamongao.product.EggJianBing;
import com.sohu.reamongao.product.JianBing;
import com.sohu.reamongao.product.SausageJianBing;

public class TianJinJianBingStore extends JianBingStore {

	@Override
	protected JianBing createJianBing(String item) {
		JianBing jb = null;
		AbsJianBingFactory ingredientFactory = 
			new TianJinJianBingFactory();
 
		if (item.equals("egg")) {
  
			jb = new EggJianBing(ingredientFactory);
			jb.setName("TianJin Style Egg JianBing");
  
		} else if (item.equals("sausage")) {

			jb = new SausageJianBing(ingredientFactory);
			jb.setName("TianJin Style Sausage JianBing");
 
		} 
		return jb;
	}

}
