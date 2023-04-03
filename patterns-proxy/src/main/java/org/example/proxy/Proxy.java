package org.example.proxy;

import org.example.service.IService;

public class Proxy implements IService {

    private IService service;

    public Proxy(IService service){
        this.service = service;
    }

    @Override
    public double compute(int parameter) {
        double result = service.compute(parameter);
        return result;
    }
}
