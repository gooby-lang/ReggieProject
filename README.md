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

## DAY3：分类管理

+   公共字段自动填充
    +   客户端每次发送HTTP请求时，对应的服务端都会分配一个新的线程来处理，处理过程中涉及到下面方法都属于一个线程
        +   LoginCheckFilter的doFilter方法
        +   EmployeeController的update方法
        +   MyMetaObjectHandler的updateFill方法

## DAY4：菜品管理

+   文件上传与下载

    +   需要在相应Controller层中对应方法参数中加入MultipartFile，其中参数名必须与前端form data中的name属性值一致，或者在参数前加入@RequestPart注解

    +   ```
        @PostMapping("/upload")
        public R<String> upload(@RequestPart("file") MultipartFile file) {
            return null;
        }
        ```

    +   但是file是一个临时文件，需要使用transferTo方法转存到其他地方

        +   可以使用UUID来命名需要转存的文件名，防止重复名称导致的文件覆盖
        +   转存时需要保证文件夹存在

    +   需要图片回显，可以使用输入输出流来读取即可

+   新增菜品

    +   如果前端返回的数据中没有和实体类对应，需要使用DTO来传输
    +   由于对多张表进行操作，需要开启事务注解@Transactional

+   菜品信息分页查询

    +   由于数据库只存储了分类的id，所以需要向前端返回DishDto实例
    +   使用Dto可以避免写多表查询
    
+   菜品的停售和启售

    +   @RequestParam用于非文件上传用的，@RequestPart通常用于文件上传
    
+   菜品的删除

## DAY5：套餐管理

+   套餐的停售与启售
    +   套餐的启售需要考虑到每个菜品的销售状态

## DAY6：用户登录



