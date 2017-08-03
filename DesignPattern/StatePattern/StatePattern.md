##状态模式

状态表示

boolean int 或 enum


###to-状态模式
不易拓展：每个行为方法均需要加入新状态的判断

- 1.没有遵守开闭原则
- 2.不符合面向对象
- 3.状态转换被埋藏在条件语句中，并不明显（应该在执行行为中切换状态）
- 4.没有把变化的部分封装起来（不变的是行为方法，变的是各状态下的行为实现，要封装每个状态的行为，将每个状态的行为都放到各自的状态类中，每个状态只需要实现自己的行为就可以了。tips：利用组合：糖果机只需要委托给当前状态对象去处理各自行为）
- 5.未来加入的代码很有可能bug

重写：
将状态对象封装在各自的类中，然后在动作行为发生时委托给当前状态

- 1.首先定义一个state接口，在这个接口里，我们定义了几个糖果机的行为方法
- 2.然后为机器的每个状态实现状态类，这些类负责实现各自状态下的糖果机的各种行为
- 3.删除原先的条件代码，将行为方法委托给状态类。


###意图：
允许对象当其内部状态改变时改变它的行为，这将会改变它的类。


**UML图**

 ![UML](https://upload.wikimedia.org/wikipedia/commons/e/e8/State_Design_Pattern_UML_Class_Diagram.svg "UML图")


###角色
- 环境(Context)角色   上下文：定义客户端所感兴趣的接口，并且持有具体状态类的实例。这个定义了对象的当前状态
- 抽象状态(State)角色
定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
- 具体状态(ConcreteState)角色
每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。

### 策略模式VS状态模式
状态模式处理对象的(状态或类型)(in)——它封装了依赖于状态的行为，而策略模式处理对象执行特定任务的方式——它封装了一个算法。

###优点：


###缺点：
增加了状态类的个数


###适用情况：

- 1.一个对象的行为由它的状态决定，并且它需要在运行时根据状态决定行为
- 2.行为或运行根据对象的状态有大量，多部分的条件语句。这些状态通常用一个或多个枚举常量代表。通常，许多操作包含相同的条件结构。状态模式将条件的每个分支放在一个单独的类中。这允许您将对象的状态作为一个对象来处理，它可以独立于其他对象。


### 总结：
状态模式的关键点在于不同的状态下对于同一行为有不同的响应，这其实就是将if-else用多态来实现的过程。

### 参考：

- Head First 设计模式
- Android源码设计模式解析与实战