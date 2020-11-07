# JavaWeb
## JSP

### 8.1 什么是JSP?
* Java Server Pages：Java服务器端页面，也和Servlet一样，用于动态Web技术！
* 最大的特点：
  * 写JSP就像是在写HTML
  * 和Html的区别：
    * Html只给用户提供静态的数据
    * JSP页面中可以嵌入JAVA代码，为用户提供动态数据。



### 8.2 JSP原理

思路：JSP代码到底是怎么执行的?

* 代码层面没有任何问题

* 服务器内部工作

  * tomcat中有一个work目录
  * IDEA中使用Tomcat的会在IDEA的tomcat中产生一个work目录，这里面存储的是JSP转换后的.java文件和.class文件
  * **浏览器向服务器发送请求，不管访问什么资源，其实都是在访问Servlet！**
  * JSP最终也会转换为一个JAVA类！

* **JSP本质上就是一个Servlet！**比如项目中的index.jsp转换成的java文件是index_jsp.java：

  ```java
  public final class index_jsp extends HttpJspBase implements JspSourceDependent, JspSourceImports {
    // 初始化
    public void _jspInit() {
    }
    // 销毁
    public void _jspDestroy() {
    }
    // JSPService
    public void _jspService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	// ....      
      final javax.servlet.jsp.PageContext pageContext;
      javax.servlet.http.HeepSession session = null;
      final javax.servlet.ServletContext application;
      final javax.servlet.ServletConfig config;
      javax.servlet.jsp.JspWriter out = null;
      final java.lang.Object page = this;
      javax.servlet.jsp.JspWriter _jspx_out = null;
      javax.servlet.jsp.PageContext _jspx_page_context = null;
      // ...
    }
  }
  ```

  HttpJspBase的源码：

  ```java
  public interface HttpJspPage extends JspPage {
      public void _jspService(HttpServletRequest request,
                              HttpServletResponse response)
         throws ServletException, IOException;
  }
  ```

  JspPage的源码：

  ```java
  public interface JspPage extends Servlet {
      public void jspInit();
      public void jspDestroy();
  }
  ```

  Servlet的源码：

  ```java
  public interface Servlet {
      public void init(ServletConfig config) throws ServletException;
  
      public ServletConfig getServletConfig();
      
      public void service(ServletRequest req, ServletResponse res)
  	throws ServletException, IOException;
      
      public String getServletInfo();
      
      public void destroy();
  }
  ```

* index_jsp中_jspService函数的运行过程：

  1. 判断请求

  2. 内置一些对象

     ```java
     final javax.servlet.jsp.PageContext pageContext;	// 页面上下文
     javax.servlet.http.HeepSession session = null;		// session
     final javax.servlet.ServletContext application;		// application
     final javax.servlet.ServletConfig config;			// config
     javax.servlet.jsp.JspWriter out = null;				// out
     final java.lang.Object page = this;					// this:当前页面
     HttpServletRequest request; 						// 请求
     HttpServletResponse response;						// 响应
     ```

  3. 输出页面前增加的代码

     ```java
     response.setContentType("text/html; charset=UTF-8");  // 设置响应的页面类型
     pageContext = _jspxFactory.getPageContext(this, request, response,
                                               null, false, 8192, true);
     _jspx_page_context = pageContext;
     application = pageContext.getServletContext();
     config = pageContext.getServletConfig();
     session = pageContext.getSession();
     out = pageContext.getOut();
     _jspx_out = out;
     ```

  4. 内置的9大对象我们可以在JSP页面中直接使用！

* 在JSP页面中：

  * 只要是JAVA代码就会被原封不动的输出；

  * 如果是HTML代码，会被转换成：

    ```java
    out.write("<html>\r\n")
    ```

    这样的格式，输出到前端！



### 8.3 JSP基础语法

请查看index.jsp



### 8.4 JSP指令

请查看：index2.jsp、index3.jsp、index4.jsp、header.jsp、footer.jsp



### 8.5 九大内置对象

* PageContext    存东西
* Request    存东西
* Response
* Session    存东西
* Application     [ServletContext]    存东西
* config    [ServletConfig]
* out
* page , 不用
* exception

---

```java
pageContext.setAttribute("name1", "wxx01");  // 保存的数据只在一个页面中有效
request.setAttribute("name2", "wxx02");  // 保存的数据只在一次请求中有效，请求转发也会携带这个数据
session.setAttribute("name3", "wxx03");  // 保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
application.setAttribute("name4", "wxx04");  // 保存的数据在服务器中有效，从打开服务器到关闭服务器
```

* 使用场景
  * request：客户端向服务器发送请求，产生的数据，用户看完就没用了，比如：新闻，用户看完就没用了；
  * session：客户端向服务器发送请求，产生的数据，用户看完一会还有用，比如：购物车；
  * application：客户端向服务器发送请求，产生的数据，一个用户用完了，其他用户还可能使用，比如：聊天数据；

请查看：pageContextDemo01.jsp、pageContextDemo02.jsp、pageContextDemo03.jsp



### 8.6 JSP标签、JSTL标签、EL表达式

* JSP标签
  * 请参考 jsptag1.jsp、jsptag1.jsp
* JSTL标签
  * JSTL标签库的使用就是为了弥补HTML标签的不足；它自定义了许多标签，可以供我们使用，标签的功能和Java代码一样。（不使用也行，用Java语言完全可以代替，用的目的是为了美观）
  * 分类
    * 核心标签（掌握部分）
    * 格式化标签
    * SQL标签
    * XML标签
  * 使用步骤
    * 引入对应的taglib
    * 使用其中的方法
  * 请参考jstlcore1.jsp、jstlcore2.jsp、jstlcore3.jsp
* EL表达式：${ }
  * 获取数据
  * 执行运算
  * 获取web开发常用对象























