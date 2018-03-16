package my.codebank.jetty.server;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import static org.apache.log4j.Logger.getLogger;

public class MyJettyServer {

    public static Logger logger = getLogger("MyJettyServerLogger");

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ContextHandler contextRoot = new ContextHandler();
        contextRoot.setContextPath("/");
        contextRoot.setHandler(new HelloHandler("Context [/] greeting"));

        ContextHandler contextFr = new ContextHandler();
        contextFr.setContextPath("/fr");
        contextFr.setHandler(new HelloHandler("Context [/fr] Bonjoir"));


        ContextHandler contextIt = new ContextHandler();
        contextIt.setContextPath("/it");
        contextIt.setHandler(new HelloHandler("Context [/it] Bongiorno"));


        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {contextRoot, contextFr, contextIt });

        server.setHandler(contexts);

        server.start();
        server.join();
    }
}
