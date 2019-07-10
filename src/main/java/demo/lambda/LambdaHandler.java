package demo.nakedlambda.lambda;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public final class LambdaHandler
  extends SpringBootRequestHandler<String, String> {

}
