
package fooddelivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderPlacedPolicyTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(EventTest.class);
   
   @Autowired
   private KafkaProcessor processor;
   @Autowired
   private MessageCollector messageCollector;
   @Autowired
   private ApplicationContext applicationContext;


   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  

      entity.setRiderId("N/A");
      entity.setRiderName("N/A");
      entity.setRiderStatus("N/A");

      repository.save(entity);

      //when:  
      
      OrderPlaced event = new OrderPlaced();

      event.setOrderId("order123");
      event.setFoodSelection("피자");
      event.setQuantity(2L);
      event.setSpecialRequest("안 마늘 넣어주세요");
      event.setDeliveryAddress([object Object]);
      event.setPaymentMethod("카드");
      event.setOrderAmount([object Object]);
      
      InventoryApplication.applicationContext = applicationContext;

      ObjectMapper objectMapper = new ObjectMapper();
      try {
         String msg = objectMapper.writeValueAsString(event);

         processor.inboundTopic().send(
            MessageBuilder
            .withPayload(msg)
            .setHeader(
               MessageHeaders.CONTENT_TYPE,
               MimeTypeUtils.APPLICATION_JSON
            )
            .setHeader("type", event.getEventType())
            .build()
         );

         //then:

         Message<String> received = (Message<String>) messageCollector.forChannel(processor.outboundTopic()).poll();

         assertNotNull("Resulted event must be published", received);



         LOGGER.info("Response received: {}", received.getPayload());

         assertEquals(outputEvent.getOrderId(), "order123");
         assertEquals(outputEvent.getRiderId(), "rider123");


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }

}
