## Builder 建造者模式
### UML图
![](http://7xsxll.com1.z0.glb.clouddn.com/builder.png)

### 角色说明
- director
控制builder生成product

- builder
负责构造和组件product

- product
具体产品

### 例子说明
BuilderCommonExample 为简化版建造者模式便于构造函数创建，具体表现为
1.固定入参
2.保证顺序 
3. 链式入参

### 与工厂模式对比
两者侧重点不同，工厂模式重在创建对象，builder模式重在创建对象过程中的参数构造