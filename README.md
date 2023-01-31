# ReggieProject

## DAY1：登录功能和退出功能

遇到的一些点：

+   关于静态资源的拦截
    +   可以自己写一个配置类，通过实现WebMvcConfigurer接口，重写其中的addReourceHandlers来进行静态资源的映射
+   实体类需要实现Serializable接口
    +   实现Serializable接口后可以实现实体类的序列化，即将对象状态转换为可保持或传输的格式的过程
+   关于数据库层（mapper）可以写接口的时候继承BaseMapper

    +   这个是Mybatis Plus中的一个接口，自带很多CRUD的方法，可以直接调用来实现简单的SQL操作
+   登录过程中，密码需要进行MD5加密，再去查询数据库

## DAY2：员工业务管理开发

+   修复未登录但是能看到主页的BUG
    +   需要设定为如果未登录，就跳转到登录界面
    +   可以使用拦截器来实现路由跳转
        +   1、创建自定义过滤器
        +   2、在启动类上假如注解@ServletComponentScan
        +   3、完善过滤器的处理逻辑
    +   注意在拦截器使用中，前端的跳转需要写绝对路径，不可以写相对路径
+   添加管理员操作
    +   针对开发过程中需要捕获的异常，需要创建全局异常捕获，然后返回给前端
+   修改管理员操作
    +   对于js来说，id传到前端的时候会有精度丢失，需要配置对象映射器，将long类型的id映射成string显示

## DAY3：

+   公共字段自动填充
    +   客户端每次发送HTTP请求时，对应的服务端都会分配一个新的线程来处理，处理过程中涉及到下面方法都属于一个线程
        +   LoginCheckFilter的doFilter方法
        +   EmployeeController的update方法
        +   MyMetaObjectHandler的updateFill方法