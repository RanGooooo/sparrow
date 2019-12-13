流程部署相关表
	act_re_deployement 部署对象表
	act_rep_procdef  流程定义表
 	act_ge_bytearray 资源文件表
	act_ge_prperty  主键生成策略表（对于部署对象表的主键ID） 
流程实例相关表
	act_ru_execution 正在执行的执行对象表（包含执行对象ID和流程实例ID，如果有多个线程可能流程实例ID不一样）
	act_hi_procinst 流程实例历史表
	act_hi_actinst 存放历史所有完成的任务
Task 任务相关表
	act_ru_task 代办任务表 （只对应节点是UserTask的）
	act_hi_taskinst 代办任务历史表 （只对应节点是UserTask的） 
	act_hi_actinst 所有节点活动历史表（对应流程的所有节点的活动历史，从开始节点一直到结束节点中间的所有节点的活动都会被记录）
流程变量表
	act_ru_variable 正在执行的流程变量表
	act_hi_variable 流程变量历史表
	
1、act_ge_ 通用数据表，ge是general的缩写
2、act_hi_ 历史数据表，hi是history的缩写，对应HistoryService接口
3、act_id_ 身份数据表，id是identity的缩写，对应IdentityService接口
4、act_re_ 流程存储表，re是repository的缩写，对应RepositoryService接口，存储流程部署和流程定义等静态数据
5、act_ru_ 运行时数据表，ru是runtime的缩写，对应RuntimeService接口和TaskService接口，存储流程实例和用户任务等动态数据
    


表结构操作： 
3.3.1：资源库流程规则表 
1) act_re_deployment 部署信息表 
2) act_re_model 流程设计模型部署表 
3) act_re_procdef 流程定义数据表 
3.3.2：运行时数据库表 
1) act_ru_execution 运行时流程执行实例表 
2) act_ru_identitylink 运行时流程人员表，主要存储任务节点与参与者的相关信息 
3) act_ru_task 运行时任务节点表 
4) act_ru_variable 运行时流程变量数据表 
3.3.3：历史数据库表 
1) act_hi_actinst 历史节点表 
2) act_hi_attachment 历史附件表 
3) act_ih_comment 历史意见表 
4) act_hi_identitylink 历史流程人员表 
5) act_hi_detail 历史详情表，提供历史变量的查询 
6) act_hi_procinst 历史流程实例表 
7) act_hi_taskinst 历史任务实例表 
8) act_hi_varinst 历史变量表 
3.3.4：组织机构表 
1) act_id_group 用户组信息表 
2) act_id_info 用户扩展信息表 
3) act_id_membership 用户与用户组对应信息表 
4) act_id_user 用户信息表 
这四张表很常见，基本的组织机构管理，关于用户认证方面建议还是自己开发一套，组件自带的功能太简单，使用中有很多需求难以满足 
3.3.5：通用数据表 
1) act_ge_bytearray 二进制数据表 
2) act_ge_property 属性数据表存储整个流程引擎级别的数据,初始化表结构时，会默认插入三条记录， 
3.4：activiti.cfg.xml（activiti的配置文件） 
Activiti核心配置文件，配置流程引擎创建工具的基本参数和数据库连接池参数。 
定义数据库配置参数： 
 jdbcUrl: 数据库的JDBC URL。 
 jdbcDriver: 对应不同数据库类型的驱动。 
 jdbcUsername: 连接数据库的用户名。 
 jdbcPassword: 连接数据库的密码。 
基于JDBC参数配置的数据库连接 会使用默认的MyBatis连接池。 下面的参数可以用来配置连接池（来自MyBatis参数）： 
 jdbcMaxActiveConnections: 连接池中处于被使用状态的连接的最大值。默认为10。 
 jdbcMaxIdleConnections: 连接池中处于空闲状态的连接的最大值。 
 jdbcMaxCheckoutTime: 连接被取出使用的最长时间，超过时间会被强制回收。 默认为20000（20秒）。 
 jdbcMaxWaitTime: 这是一个底层配置，让连接池可以在长时间无法获得连接时， 打印一条日志，并重新尝试获取一个连接。（避免因为错误配置导致沉默的操作失败）。 默认为20000（20秒）。