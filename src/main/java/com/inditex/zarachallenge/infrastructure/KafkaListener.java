package com.inditex.zarachallenge.infrastructure;

import java.util.function.Consumer;

import com.inditex.zarachallenge.app.service.ProductService;
import com.inditex.zarachallenge.domain.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.domain.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

	@Autowired
	private ProductService productService;

	@Bean
	public Consumer<Message<ProductAvailabilityEvent>> KafkaConsumer() {
		return message -> {
			ProductAvailabilityEvent event = message.getPayload();
			productService.updateStockAvailability(event);
		};
	}

}
