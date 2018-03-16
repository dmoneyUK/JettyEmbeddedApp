# JettyEmbeddedApp

A Jetty server which uses the a ServletContext to produce a response to a request. 

Embedding ServletContexts

A ServletContextHandler is a specialization of ContextHandler with support for standard sessions 
and Servlets. The following OneServletContext example instantiates a DefaultServlet to server 
static content from /tmp/ and a DumpServlet that creates a session and dumps basic details about 
the request:s the request, it does so within the scope the ServletHandler has established.