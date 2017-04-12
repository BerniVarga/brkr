package brkr.webserver;

import brkr.springconfig.AppConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EmbeddedJetty {

    public static final String CONTEXT_PATH_RESPOND_TO_ALL_REQUESTS = "/";
    public static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        new EmbeddedJetty().startJetty(PORT);
    }

    private void startJetty(int port) throws Exception {
        Server server = new Server(port);
        WebApplicationContext webApplicationContext = createWebApplicationContext();
        ServletContextHandler handler = createHandlerUsing(webApplicationContext);
        server.setHandler(handler);
        server.start();
        server.join();
    }

    private ServletContextHandler createHandlerUsing(WebApplicationContext webApplicationContext){
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath(CONTEXT_PATH_RESPOND_TO_ALL_REQUESTS);
        ServletHolder dispatcherServletHolder = new ServletHolder(new DispatcherServlet(webApplicationContext));
        servletContextHandler.addServlet(dispatcherServletHolder,CONTEXT_PATH_RESPOND_TO_ALL_REQUESTS);
        servletContextHandler.addEventListener(new ContextLoaderListener(webApplicationContext));
        return servletContextHandler;
    }

    private WebApplicationContext createWebApplicationContext(){
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfig.class);
        return applicationContext;
    }
}
