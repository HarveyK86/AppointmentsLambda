package demo.nakedlambda.service;

import demo.nakedlambda.entity.Entity;
import demo.nakedlambda.handler.Request;

import java.util.List;

public interface Service<E extends Entity> {

  boolean canHandle(Request request);

  List<E> get(Request request);

  void post(Request request);

}