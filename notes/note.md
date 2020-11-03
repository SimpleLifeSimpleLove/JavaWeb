web.xml
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">


</web-app>
```

Error:(3, 21) java: 程序包javax.servlet不存在
    解决：https://blog.csdn.net/GK666_/article/details/106442929

添加jar包
D:\MyPrograms\apache-tomcat-9.0.39\lib\servlet-api.jar


