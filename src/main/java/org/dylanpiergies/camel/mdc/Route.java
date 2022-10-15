package org.dylanpiergies.camel.mdc;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class Route extends EndpointRouteBuilder {
  @Override
  public void configure() {
    from(direct("start"))
        .process(exchange -> {
          MDC.put("custom.exchangeId", exchange.getExchangeId());
          var logger = LoggerFactory.getLogger(exchange.getFromRouteId());
          logger.info("Log from Processor");
        })
        .log("Log from route")
        .to(mock("end"))
        .delay(1000)
        .log("Delayed log from route");
  }
}
