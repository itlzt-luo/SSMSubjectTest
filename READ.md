#SSM实验作业二：Mybatis实现一对一，一对多数据插入数据

**基于SqlSession的ExecutorType进行批量插入**
##主要代码

###service
~~~java
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //添加数据
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    //批量添加数据
    public void batchUser(List<User> userList) {
        for (User user : userList) {
            userMapper.insertUser(user);
        }
    }
}
~~~

###mapper
~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ssmTest.mapper.UserMapper">
    <resultMap id="BaseResultMap" type="com.ssmTest.model.User">
        <id column="id" jdbcType="BIGINT" property="id"/>
        <result column="name" jdbcType="VARCHAR" property="name"/>
        <result column="password" jdbcType="VARCHAR" property="password"/>
        <result column="sex" jdbcType="VARCHAR" property="sex"/>
        <result column="email" jdbcType="VARCHAR" property="email"/>
    </resultMap>
    <insert id="insertUser" parameterType="com.ssmTest.model.User">
        insert into user(name, password, sex, email) values (#{name}, #{password}, #{sex}, #{email});
    </insert>
</mapper>
~~~

##演示
`com.ssmTest.UserInsertTest`

##配置文件
applicationContext.xml
spring-dao.xml
spring-mvc.xml
spring-service.xml
mybatis-config.xml

基于`SqlSession`的`ExecutorType`进行批量插入 `spring-dao.xml`配置
~~~xml
    <!-- 配置一个可以批量执行的sqlSession -->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg name="sqlSessionFactory" ref="sessionFactory"></constructor-arg>
        <constructor-arg name="executorType" value="BATCH"></constructor-arg>
    </bean>
~~~
