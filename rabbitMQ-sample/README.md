rabbitMQ-sample  
===============
rabbitMQ 基础示例:(win7)安装、测试


###1. 创建项目：
	1. mvn指令：mvn archetype:generate -DgroupId=com.william.rabbitMQ.sample -DartifactId=rabbitMQ-sample -DpackageName=com.william.rabbitMQ.sample.model -Dversion=0.0.1-SNAPSHOT
	2. 添加 Publisher/Consumer 类

> [com.william.rabbitMQ.sample.Publisher   (消息)生产者](src/main/java/com/william/rabbitMQ/sample/Publisher.java)
<br/>
> [com.william.rabbitMQ.sample.Consumer    (消息)消费者](src/main/java/com/william/rabbitMQ/sample/Consumer.java)


###2. rabbitMQ server安装
	1. 下载erlang支持包：http://www.erlang.org/download.html
	2. 下载rabbitmq server：http://www.rabbitmq.com/download.html
	3. 配置环境变量
		- 新建变量：ERLANG_HOME=C:\Program Files\erl8.1，然后再path中添加%ERLANG_HOME%\bin
		- 新建变量：RABBITMQ_SERVER=C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.5，然后在path中添加 %RABBITMQ_SERVER%\sbin
	4. 启动RabbitMQ服务器,运行 net start rabbitMQ

###3. 程序测试
	1. 先后运行 Consumer/Publisher 程序
	2. 在 Publisher 程序运行以后，输入想要发送的MQ消息
	3. 观察到 Consumer 程序是否获取到消息，如果获取到，表示整个测试成功