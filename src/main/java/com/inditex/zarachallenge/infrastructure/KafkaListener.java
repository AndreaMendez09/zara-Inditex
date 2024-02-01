package com.inditex.zarachallenge.infrastructure;

import java.util.function.Consumer;

import com.inditex.zarachallenge.app.service.ProductService;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

	@Autowired
	private final ProductService productService;

    public KafkaListener(ProductService productService) {
        this.productService = productService;
    }

    @Bean
	public Consumer<Message<ProductAvailabilityEvent>> KafkaConsumer() {
		return message -> {
			ProductAvailabilityEvent event = message.getPayload();
			productService.updateStockAvailability(event);
		};
	}

}
