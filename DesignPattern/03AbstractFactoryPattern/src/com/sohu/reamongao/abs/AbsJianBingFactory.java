package com.sohu.reamongao.abs;


/**
 * 抽象工厂，负责创建所有原料
 *
 */
public interface AbsJianBingFactory {
	/**
	 * 在接口中，每个原料都有一个对应的方法创建该原料
	 */
	public Dough createDough();
	public Egg createEgg();
	public Sausage createSausage();
}
