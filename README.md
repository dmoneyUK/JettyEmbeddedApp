# JettyEmbeddedApp

A Jetty server which uses a servlet to produce a response to a request. 

Servlets are the standard way to provide application logic that handles HTTP requests. Servlets are similar 
to a Jetty Handler except that the request object is not mutable and thus cannot be modified. 

Servlets are handled in Jetty by a ServletHandler. It uses standard path mappings to match a Servlet to a request; sets 
the requests servletPath and pathInfo; passes the request to the servlet, possibly via Filters to produce a response.


Visit http://localhost:8080/ to see the response from the handler.

