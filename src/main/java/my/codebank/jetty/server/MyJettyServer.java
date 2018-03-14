package my.codebank.jetty.server;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.webapp.WebAppContext;

import static org.apache.log4j.Logger.getLogger;

public class MyJettyServer {

    public static Logger logger = getLogger("MyJettyServerLogger");
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        /* User handler */
        //ContextHandler context = new ContextHandler();
        //context.setContextPath("/hello");
        //context.setResourceBase(".");
        //context.setClassLoader(Thread.currentThread().getContextClassLoader());
        //server.setHandler(context);
        //context.setHandler(new HelloHandler());

        /* Use Servlet Context*/
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloServlet()), "/*");
        context.addServlet(new ServletHolder(new HelloServlet("Buongiorno Mondo")),"/it/*");
        context.addServlet(new ServletHolder(new HelloServlet("Bonjour le Monde")),"/fr/*");

        /* Use Application Context*/
        String jetty_home = System.getProperty("jetty.base","..");

        logger.info(jetty_home);
        //WebAppContext webapp = new WebAppContext();
        //webapp.setContextPath("/");
        //webapp.setWar(jetty_home+"/webapps/test.war");
        //server.setHandler(webapp);

        server.start();
        server.join();
    }
}
