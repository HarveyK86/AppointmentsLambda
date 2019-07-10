package demo.nakedlambda.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public final class VoidHandler extends SpringBootRequestHandler<Void, String> {

}