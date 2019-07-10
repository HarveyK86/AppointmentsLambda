package demo.nakedlambda.lambda;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public final class ApplicationsFunction implements Function<String, String> {

  @Override
  public String apply(final String input) {
    return input.toUpperCase();
  }

}
