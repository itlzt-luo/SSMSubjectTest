#SSM实验作业三、四
##SpringMVC使用拦截器实现用户登录权限验证
###拦截器注册 spring-mvc.xml
~~~xml
    <!--拦截器注册-->
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <mvc:exclude-mapping path="/login"/>
            <mvc:exclude-mapping path="/toLogin"/>
            <mvc:exclude-mapping path="/assets/**"/>
            <bean class="com.ssmTest.interceptor.LogInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
~~~
###拦截器com.ssmTest.interceptor.LogInterceptor
~~~java
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        /*判断是否已经登录*/
        if (account == null) {
            response.sendRedirect("/toLogin");
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
~~~
##Mybatis实现关联映射 
### mapper文件 com.ssmTest.mapper.AccountMapper.xml
~~~xml
    <resultMap id="UserBaseResultMap" type="com.ssmTest.model.User">
        <id column="id" jdbcType="BIGINT" property="id"/>
        <result column="login_name" jdbcType="VARCHAR" property="loginName"/>
        <result column="password" jdbcType="VARCHAR" property="password"/>
        <association property="student" column="id" javaType="student" select="com.ssmTest.mapper.StudentMapper.selectByAccountId"/>
    </resultMap>
    
    <select id="selectById" parameterType="com.ssmTest.model.Account" resultMap="UserBaseResultMap">
        select * from account
        where id = #{id}
    </select>
~~~

