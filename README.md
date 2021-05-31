# maven-IDEA-
1.创建项目，导入Html页面，配置文件，jar包
2.创建数据库环境
3.创建 包domain，创建类User——用户的实体类
4.创建 包dao，创建类UserDao,提供login方法
5.创建 包Utils，创建JDBC工具类，使用Druid连接池
6.使用步骤5，获取到的DataSource，创建JdbcTemplate查找数据库（username,password)
//测试代码，测试DAO中 login方法是否成功
7.创建servlet：
	LoginServlet：用来获取输入的用户信息，判断登录条件
	successfulServlet：成功界面
	failLogin:失败界面
