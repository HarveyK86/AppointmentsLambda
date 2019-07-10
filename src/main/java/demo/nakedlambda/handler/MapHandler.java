package demo.nakedlambda.handler;

import java.util.Map;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public final class MapHandler extends SpringBootRequestHandler<Map<String, String>, String> {

}