package demo.nakedlambda.handler;

import demo.nakedlambda.Application;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LambdaHandler implements RequestStreamHandler {

  private static final SpringBootLambdaContainerHandler<AwsProxyRequest,
    AwsProxyResponse> HANDLER;

  static {
    try {
      HANDLER = SpringBootLambdaContainerHandler.getAwsProxyHandler(
        Application.class);
    } catch(final ContainerInitializationException e) {
      throw new RuntimeException(e);
    }
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(
    LambdaHandler.class);

  @Override
  public void handleRequest(final InputStream inputStream,
    final OutputStream outputStream, final Context context) throws IOException {
    final String message= String.format("handleRequest[inputStream==%s, "
      + "outputStream==%s, context==%s]", inputStream, outputStream, context);
    LOGGER.info(message);
    HANDLER.proxyStream(inputStream, outputStream,context);
    outputStream.close();
  }

}