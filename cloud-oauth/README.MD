

不通过zuul路由模式
 首先启动 oauth-com.louis.comment.web:
 然后 localhost:9879/api/auth/login 登录，获取预先输入进系统的账号和密码 获取token
 这个时候 可以通过postman在url的header中的key 输入“X-Authorization”，value输入“TOKEN_”+系统生成的token
 这个时候带着这个header就能访问WebSecurityConfig 有权限验证的那些路径了
 
 
 通过zuul路由模式
