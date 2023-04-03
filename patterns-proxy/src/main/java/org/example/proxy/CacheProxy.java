package org.example.proxy;

import org.example.service.IService;
import org.example.service.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements IService {

    private Map<Integer, Double> caches = new HashMap<>();

    private IService service;

    public CacheProxy(IService service){
        this.service = service;
    }
    @Override
    public double compute(int parameter) {
        Double cacheValue = caches.get(parameter);
        if(cacheValue != null){
            System.out.println("----------- cache result --------------");
            return cacheValue;
        }else{
            double result = service.compute(parameter);
            caches.put(parameter, result);
            System.out.println("---------- new computing result -------");
            return result;
        }
    }
}
