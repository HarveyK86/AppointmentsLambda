package demo.nakedlambda.handler;

import demo.nakedlambda.entity.Entity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Response {

  private List<Entity> entities;

  private static final String CLASS_NAME = Response.class.getSimpleName();

  private static final Logger LOGGER = LoggerFactory.getLogger(Response.class);

  public Response() {
    super();
    final String message = String.format("%s instantiated", CLASS_NAME);
    LOGGER.info(message);
  }

  public List<Entity> getEntities() {
    return this.entities;
  }

  public void setEntities(final List<Entity> entities) {
    final String message = String.format("setEntities[entities==%s]", entities);
    LOGGER.info(message);
    this.entities = entities;
  }

  @Override
  public String toString() {
    return String.format("%s[]", CLASS_NAME);
  }

}
