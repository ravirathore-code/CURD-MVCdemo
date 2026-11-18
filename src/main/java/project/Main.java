package project;

import configu.CustomerConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {


        Tomcat tomcat =new Tomcat() ;
        tomcat.setPort(8080);
        tomcat.getConnector();

        String ContextPath = " " ;
        String baseDoc = new File("src/main/webApp")
                .getAbsolutePath() ;

        Context context = tomcat.addContext(ContextPath,baseDoc) ;


        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext() ;

        springContext.register(CustomerConfig.class);

        // dispatcher Servlet

        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext) ;

        tomcat.addServlet(context,"dispatcherServlet", dispatcherServlet) ;

        context.addServletMappingDecoded("/" , "dispatcherServlet");

        tomcat.start();
        System.out.println(" Tomcat Server is started ");
        tomcat.getServer().await(); ;
    }
}