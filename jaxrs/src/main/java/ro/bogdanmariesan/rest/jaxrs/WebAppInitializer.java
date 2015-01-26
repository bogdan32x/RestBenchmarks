package ro.bogdanmariesan.rest.jaxrs;

import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.plugins.spring.SpringContextLoaderListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by bogdan.mariesan on 1/24/2015.
 */
public class WebAppInitializer{
//        implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        WebApplicationContext context = getContext();
//        container.addListener(new ResteasyBootstrap());
//        container.addListener(new SpringContextLoaderListener());
//
//        ServletRegistration.Dynamic dispatcher = container.addServlet("appServlet", new DispatcherServlet(context));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/*");
//    }
//
//    private AnnotationConfigWebApplicationContext getContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.setConfigLocation("ro.bogdanmariesan.rest");
//        return context;
//    }
}