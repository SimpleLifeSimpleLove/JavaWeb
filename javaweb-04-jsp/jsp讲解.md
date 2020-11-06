# JavaWeb
## JSP

### 8.1 什么是JSP?
* Java Server Pages：Java服务器端页面，也和Servlet一样，用于动态Web技术！
* 最大的特点：
  * 写JSP就像是在写HTML
  * 和Html的区别：
    * Html只给用户提供静态的数据
    * JSP页面中可以嵌入JAVA代码，为用户提供动态数据。



### 8.1 JSP原理

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

  4. 内置的8大对象我们可以在JSP页面中直接使用！

