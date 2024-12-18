package de.telran.onlineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShopApplication {
//  Разделите код в нашем проекте online магазина на Controller и Service слои.
//Для внедрения сервис слоя в контроллеры используйте "инъекция через контроллер".
//Проставьте при успешной работе контроллера требуемый HttpStatus Response (например):
//1) для операции Get - 200.
//2) POST - 201
//3) PUT - 202
//4) DELETE - 204
//
//Для одного из контроллеров, используйте механизм формирования ответа пользователю
//через класс-обвертку EntityResponse

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

}
