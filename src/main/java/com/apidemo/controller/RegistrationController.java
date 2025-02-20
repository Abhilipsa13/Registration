package com.apidemo.controller;

import com.apidemo.entity.Registration;
import com.apidemo.payload.RegistrationDto;
import com.apidemo.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {

private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //http://localhost:8080/api/v1/register
    @PostMapping
    public String createRegistration(
       @RequestBody RegistrationDto registrationDto
        ){
       RegistrationDto registration = registrationService.createRegsitration(registrationDto);
       return "Registration is created successfully with ID:" +registration.getId();
    }

    @DeleteMapping
    public String deleteRegistration(
          @RequestParam  long id


    ){
registrationService.delete(id);
return "Registration deleted succesfully:" +id ;
    }

}
