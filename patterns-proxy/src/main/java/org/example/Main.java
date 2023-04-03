package org.example;

import org.example.proxy.CacheProxy;
import org.example.proxy.LoggingProxy;
import org.example.proxy.SecurityContext;
import org.example.proxy.SecurityProxy;
import org.example.service.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        SecurityContext.authenticate("root", "1234", "root");
        context.setService(new SecurityProxy(
                new CacheProxy(
                        new LoggingProxy(
                                new ServiceImpl()
                        )
                )
        ));
        context.compute(10);
        context.compute(20);
        context.compute(30);
        context.compute(10);
        context.compute(40);
        context.compute(20);


    }
}