package my.codebank.jetty.server;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import static org.apache.log4j.Logger.getLogger;

public class MyJettyServer {

    public static Logger logger = getLogger("MyJettyServerLogger");

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.setContextPath("/");
        servletContext.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(servletContext);

        servletContext.addServlet(HelloServlet.class, "/hello/*");
        servletContext.addServlet(DefaultServlet.class, "/");

        server.start();
        server.join();
    }
}
