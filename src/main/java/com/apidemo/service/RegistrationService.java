package com.apidemo.service;

import com.apidemo.entity.Registration;
import com.apidemo.exceptions.ResourceNotFound;
import com.apidemo.payload.RegistrationDto;
import com.apidemo.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private Registration registrationDto;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public RegistrationDto createRegsitration(
            RegistrationDto registrationDto
    ) {
        Registration registration = convertToEntity(registrationDto);
        Registration savedRegistration = registrationRepository.save(registration);

        return convertToDto(savedRegistration);

    }

    Registration convertToEntity(RegistrationDto registrationDto) {
        Registration registration = new Registration();
        registration.setName(registrationDto.getName());
        registration.setEmailId(registrationDto.getEmailId());
        registration.setMobile(registrationDto.getMobile());
        return registration;
    }

    RegistrationDto convertToDto(Registration registration) {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setName(registration.getName());
        registrationDto.setEmailId(registration.getEmailId());
        registrationDto.setMobile(registration.getMobile());
        return registrationDto;
    }


    public void delete(long id) {
        registrationRepository.deleteById(id);
    }

    public Registration getRegistrationById(long id) {
        Registration reg = registrationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Record not found")
        );

        return reg;
    }

}



