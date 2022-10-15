package org.dylanpiergies.camel.mdc;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CamelSpringBootTest
@EnableAutoConfiguration
class RouteTest {
  @Autowired
  ProducerTemplate producerTemplate;

  @EndpointInject("mock:end")
  MockEndpoint mockEndpoint;

  @Test
  public void testMDCForwarding() throws InterruptedException {
    var numMessages = 3;
    for (int i = 0; i < numMessages; i++) {
      String body = "Message " + i;
      producerTemplate.sendBody("direct:start", body);
    }
    mockEndpoint.expectedMessageCount(numMessages);
    mockEndpoint.assertIsSatisfied(5000);
  }
}
