package org.example.service;

public class ServiceImpl implements IService {
    @Override
    public double compute(int parameter) {
        double value = 33;
        try{
           Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value*parameter;
    }
}
