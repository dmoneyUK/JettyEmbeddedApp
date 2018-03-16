# JettyEmbeddedApp

A Jetty server which uses the a servlet to produce a response to a request. 

The handler sets the response status, content-type, and marks the request as handled before it generates the body 
of the response using a writer.

A handler may:
- Examine/modify the HTTP request.
- Generate the complete HTTP response.
- Call another Handler (see HandlerWrapper).
- Select one or many Handlers to call (see HandlerCollection).

One or more handlers do all request handling in Jetty. Some handlers select other specific handlers (for example, a 
ContextHandlerCollection uses the context path to select a ContextHandler); 
others use application logic to generate a response (for example, the ServletHandler passes the request to an application Servlet)
, while others do tasks unrelated to generating the response (for example, RequestLogHandler or StatisticsHandler).

Visit http://localhost:8080/ to see the response from the handler.

