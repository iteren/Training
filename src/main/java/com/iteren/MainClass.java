package com.iteren;

import com.iteren.service.IncomeSourceService;
import com.iteren.service.jms.WalletMessageSender;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(new ClassPathResource("WEB-INF/spring/spring-jms.xml"));
        ctx.refresh();
        IncomeSourceService service = ctx.getBean("incomeSourceService", IncomeSourceService.class);
        service.getAll().forEach(System.out::println);
//        IncomeSource is = new IncomeSource();
//        is.setAmount(500d);
//        is.setCurrency(Currency.USD);
//        is.setName("test");
//        is.setPlanId("July 2021");
//        is.setBalance(20d);
//        service.save(is);
//        service.getAll().forEach(System.out::println);

        WalletMessageSender sender = ctx.getBean("walletMessageSender", WalletMessageSender.class);
        sender.sendMessage("Test Message");
    }

}
