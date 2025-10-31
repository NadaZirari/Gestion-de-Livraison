package com.delivrey;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeliveryApplicationTests {

    @Test
    public void contextLoads() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull(context.getBean("vehicleService")); // vérifie que le bean existe
        assertNotNull(context.getBean("vehicleController")); // vérifie que le controller est bien créé
    }
}
