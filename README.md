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