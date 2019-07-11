package demo.nakedlambda.handler;

import com.amazonaws.services.lambda.runtime.Context;

import demo.nakedlambda.entity.Entity;
import demo.nakedlambda.service.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class RequestHandler
  implements com.amazonaws.services.lambda.runtime.RequestHandler<Request, Response> {

  @Autowired
  private List<Service> services;

  private static final Logger LOGGER = LoggerFactory.getLogger(
    RequestHandler.class);

  public Response handleRequest(final Request request, final Context context) {
    String message= String.format("handleRequest[request==%s, context==%s]",
      request, context);
    LOGGER.info(message);
    final String path = request.getPath();
    message = String.format("handleRequest > path == \"%s\"", path);
    LOGGER.info(message);
    final Response response = new Response();
    loop: for (final Service service : this.services) {
      if (service.canHandle(request)) {
        final String method = request.getMethod();
        if ("GET".equals(method)) {
          final List<Entity> entities = service.get(request);
          response.setEntities(entities);
        } else if ("POST".equals(method)) {
          service.post(request);
        }
      }
    }
    return response;
  }

}