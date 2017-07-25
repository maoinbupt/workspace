## 抽象工厂模式(Abstract Factory) ##

### 模式动机 ###
**抽象工厂模式** 在工厂方法模式中具体工厂负责生产具体的产品，每一个具体工厂对应一种具体产品，工厂方法也具有唯一性，一般情况下，一个具体工厂中只有一个工厂方法或者一组重载的工厂方法。但是有时候我们需要一个工厂可以提供多个产品对象，而不是单一的产品对象。

- [产品等级结构](http://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html)(`海尔电视机、海信电视机、TCL电视机`)
- [产品族](http://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html) (`海尔电视机、海尔电冰箱，海尔电视机`)

### 模式定义 ###

抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。属于对象创建型模式。

抽象工厂允许客户端使用抽象的接口来创建一组相关的产品，而不需要关系实际产出的具体产品是什么。这样一来，客户就可以从具体的产品中被解耦。


### 模式结构 ###
- AbstractFactory：抽象工厂
- ConcreteFactory：具体工厂
- AbstractProduct：抽象产品
- Product：具体产品
- Client：客户端
 

**UML图**

 ![UML](https://upload.wikimedia.org/wikipedia/commons/9/9d/Abstract_factory_UML.svg "UML图")

### 代码分析 ###
![UML](http://git.d.sohu.com/android/sohuvideo_gradle/raw/master/sohuVideoMobile/src/main/res/drawable-xhdpi/copyright_logo.png "UML图")

### 模式分析 ###

- 优点：
	- 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易。所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。内聚低耦合
	- 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。这对一些需要根据当前环境来决定其行为的软件系统来说，是一种非常实用的设计模式。
	- 增加新的产品族很方便，无须修改已有系统，符合“开闭原则”。


- 缺点：
    - 在添加新的产品对象时，难以扩展抽象工厂来生产新种类的产品，这是因为在抽象工厂角色中规定了所有可能被创建的产品集合，要支持新种类的产品就意味着要对该接口进行扩展，而这将涉及到对抽象工厂角色及其所有子类的修改，显然会带来较大的不便。
    开闭原则的倾斜性（增加新的工厂和产品族容易，增加新的产品等级结构麻烦）。


### 适用环境 ###

- 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是重要的。
- 系统中有多于一个的产品族，而每次只使用其中某一产品族。
- 属于同一个产品族的产品将在一起使用，换句话说，就是可以动态的切换产品簇的时候。。
- 如果要强调一系列相关产品的接口，以便联合使用它们的时候。


例如：在很多软件系统中需要更换界面主题，要求界面中的按钮、文本框、背景色等一起发生改变时，可以使用抽象工厂模式进行设计。


### 相关模式 ###
- 抽象工厂模式和工厂方法模式
- 抽象工厂模式和单例模式


### 总结 ###

- 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。


### 参考文献 ###

- [Abstract factory pattern - Wikipedia](https://en.wikipedia.org/wiki/Abstract_factory_pattern)
- [Head First 设计模式](https://book.douban.com/subject/2243615/)
- [设计模式之禅](https://book.douban.com/subject/25843319/)
- [设计模式 - 可复用面向对象软件的基础](https://book.douban.com/subject/1052241/)