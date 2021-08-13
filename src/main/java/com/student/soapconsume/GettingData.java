package com.student.soapconsume;

import com.example.howtodoinjava.schemas.school.StudentDetailsRequest;
import com.example.howtodoinjava.schemas.school.StudentDetailsResponse;
import com.student.soapconsume.SoapConnector.SoapConnector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GettingData {
    @Bean
    CommandLineRunner lookup(SoapConnector soapConnector) {
        return args -> {
            String name = "Yasin";//Default Name
            if(args.length>0){
                name = args[0];
            }

            StudentDetailsRequest request = new StudentDetailsRequest();
            request.setName(name);

            StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);

            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : "+response.getStudent().getName());
            System.out.println("Standard : "+response.getStudent().getStandard());
            System.out.println("Address : "+response.getStudent().getAddress());
            System.out.println("Age : "+response.getStudent().getAge());
        };
    }
}
