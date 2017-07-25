package com.sohu.reamongao.product;

import com.sohu.reamongao.abs.Dough;
import com.sohu.reamongao.abs.Egg;
import com.sohu.reamongao.abs.Sausage;

public abstract class JianBing {
	protected String name;
	
	/**
	 * 准备煎饼所需的原料
	 */
	protected Dough dough;
	protected Egg egg;
	protected Sausage sausage;
	
	/*
	 * 抽象方法prepare，在这个方法中，我们需要收集煎饼所需要的原料，而这些原料都来自原料工厂
	 */
	abstract public void prepare();

	public void bake() {
		System.out.println("start to bake jianbing");
	}

	public void cut() {
		System.out.println("start to cut jianbing");
	}

	public void box() {
		System.out.println("start to box jianbing");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (egg != null) {
			result.append(egg);
			result.append("\n");
		}
		if (sausage != null) {
			result.append(sausage);
			result.append("\n");
		}
		return result.toString();
	}
}
