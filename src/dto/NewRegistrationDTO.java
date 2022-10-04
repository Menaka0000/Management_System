package dto;

import entity.Registration;

public class NewRegistrationDTO {
    private Registration registration;

    public NewRegistrationDTO(Registration registration) {
        this.registration = registration;
    }

    public NewRegistrationDTO() {
    }


    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "NewRegistrationDTO{" +
                "registration=" + registration +
                '}';
    }
}
