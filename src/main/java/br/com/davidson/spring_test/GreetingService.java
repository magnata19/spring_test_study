package br.com.davidson.spring_test;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting(){
        return "Hello World";
    }
}
