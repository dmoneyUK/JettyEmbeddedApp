# JettyEmbeddedApp

A Jetty server which uses the a context to produce a response to a request. 

A ContextHandler is a ScopedHandler that responds only to requests that have a URI prefix that matches the configured context path. Requests that match the context path have their path methods updated accordingly and the contexts scope is available, which optionally may include:

- A Classloader that is set as the Thread context classloader while request handling is in scope.
- A set of attributes that is available via the ServletContext API.
- A set of init parameters that is available via the ServletContext API.
- A base Resource which is used as the document root for static resource requests via the ServletContext API.
- A set of virtual host names.


## Scoped Handlers

Much of the standard Servlet container in Jetty is implemented with HandlerWrappers that daisy chain handlers together: ContextHandler to SessionHandler to SecurityHandler to ServletHandler. However, because of the nature of the servlet specification, this chaining cannot be a pure nesting of handlers as the outer handlers sometimes need information that the inner handlers process. For example, when a ContextHandler calls some application listeners to inform them of a request entering the context, it must already know which servlet the ServletHandler will dispatch the request to so that the servletPath method returns the correct value.

The HandlerWrapper is specialized to the ScopedHandler abstract class, which supports a daisy chain of scopes. For example if a ServletHandler is nested within a ContextHandler, the order and nesting of execution of methods is:

```
Server.handle(...)
  ContextHandler.doScope(...)
    ServletHandler.doScope(...)
      ContextHandler.doHandle(...)
        ServletHandler.doHandle(...)
          SomeServlet.service(...)
```
Thus when the ContextHandler handles the request, it does so within the scope the ServletHandler has established.