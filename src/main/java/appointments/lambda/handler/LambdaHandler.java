package appointments.lambda.handler;

import appointments.lambda.Application;

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

  @Override
  public void handleRequest(final InputStream inputStream,
    final OutputStream outputStream, final Context context) throws IOException {
    HANDLER.proxyStream(inputStream, outputStream,context);
  }

}