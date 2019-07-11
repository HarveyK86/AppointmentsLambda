package demo.nakedlambda.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Request {

  private String method;
  private String path;

  private static final String CLASS_NAME = Request.class.getSimpleName();

  private static final Logger LOGGER = LoggerFactory.getLogger(Request.class);

  public Request() {
    super();
    final String message = String.format("%s instantiated", CLASS_NAME);
    LOGGER.info(message);
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(final String path) {
    final String message = String.format("setPath[path==\"%s\"]", path);
    LOGGER.info(message);
    this.path = path;
  }

  public String getMethod() {
    return this.method;
  }

  public void setMethod(final String method) {
    final String message = String.format("setMethod[method==\"%s\"]", method);
    LOGGER.info(message);
    this.method = method;
  }

  @Override
  public String toString() {
    final String method = this.getMethod();
    final String path = this.getPath();
    return String.format("%s[method==\"%s\", path==\"%s\"]", CLASS_NAME, method,
      path);
  }

}
