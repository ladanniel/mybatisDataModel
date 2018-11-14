resultMap使用：
如果查询出来的列明和属性名不一致，通过定义一个resultMap对列名和pojo属性名做一个映射关系
动态sql:mybatis 核心
对sql语句进行灵活操作，拼接，组装等
sql片段：
将之前实现的动态sql判断代码片段抽取出来，组成一个sql片段，其他的statement中就可以引用该sql片段
foreach标签：
向sql中传递了数组或集合，就需要使用foreach
例如：在用户查询和查询总数中 增加多个id输入查询
【数据库表分析：】
数据模型分析
1、分析每张表记录的内容 ：不用看每张表而是
      分模块对每张表记录的数据内容   相当于 学习系统需求（功能）的过程
2、每张表 重要的数据库字段
    重要字段：飞空字段，外键字段
3、以上分析后 就相当于分析了数据库级别表与表之间的关系   外键关系
4、表与表之间的业务关系
    在分析表与表之间的业务关系时， 一定要 建立 在某个业务意义基础上去分析
    
    
    
    数据模型的分析：
    
    order订单表：记录了用户购买商品的订单
    orderDetail：订单明细表：记录了订单的详细信息（订单购买商品的）
    iterms：商品表：记录了商品信息
    user 表
    id 没有意义 自增
    order ：
    id 没有任何意义 订单号
    user_id 外键
    
    orderDetail
    id
    user_id 用户id  外键
    iterms_id 商品id 外键
    下一步：
==================
    分析外键关系
==================
    
 user ---指向--->user_id
 orderDetail--------指向------>order_id
 ==================
 分析表与表的业务关系
 ====================
 先分析数据库级别的之间的业务关系
 ===========================
 user ---  order  :一个用户可以创建多个订单 ： 一对多
 
 
 order --- user   ：一个订单只由一个用户创建 ： 一对一     或者多个订单由一个用户创建：多对一
 
 
 order ---- orderDatil ：一个订单可以包含多个订单明细 一个订单可以购买多个商品 每个商品的购买信息 一对多
 
 orderDetail ----- order :一个订单明细 只有一个订单  一对一
 
 orderDetail ------ iterms：一个明细 只记录了一个商品购买信息： 一对一
 
 iterms -----  orderDetails:一个商品可以在多个订单明细中 ： 一对多
 ==================================
 数据库级别表之间没有关系的表之间的关系
 ==================================
 order  ------ (orderDatil)-------iterms  建立关系    ：一对多 
 
 iterms ------ (orderDatil)------- order 一对多
 
 综合起来 order与iterms是多对多关系
 
 User ----(order)---- (orderDatil)-------iterms : 多对多关系
 
 例如：查询订单信息，关联查询创建订单的用户信息
 
 主表：订单表   关联表 ：用户表
 
 关联查询？内链接？外连接？
 订单------关联-----用户
 order：uer_id------->user  id :只能查询一条记录
 内连接：select order.*,user.name from order,user where order.user_id = user.id
 
 分别在pojo中建立order.java iterms.java orderDetails.java实体类：作用sql查询的结果映射到实体类中
原始order.java不能映射全部字段，需要新创建pojo,创建一个实体类 extends 包括查询字段较多的po类
 
 resultMap可以实现延迟加载
 
 延迟加载
 resultMap使用association /collection实现一对一，一对多映射，association /collection具备延迟加载功能
 如果查询订单并且关联查询用户信息，如果先查询订单信息即可满足，当我们要查询用户信息是在查询用户信息，吧对用户信息
 按需查询 就成为延迟加载，可以提高数据库性能，比关联查询快
    