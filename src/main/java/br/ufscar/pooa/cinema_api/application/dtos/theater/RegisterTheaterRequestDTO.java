package br.ufscar.pooa.cinema_api.application.dtos.theater;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class RegisterTheaterRequestDTO {

        @NotBlank
        private String name;

        private String logoUrl;

        private AddressDTO address;

        @NotEmpty
        private List<Long> managerIds;

        public RegisterTheaterRequestDTO() {
        }

        public RegisterTheaterRequestDTO(String name, String logoUrl, AddressDTO address, List<Long> managerIds) {
                this.name = name;
                this.logoUrl = logoUrl;
                this.address = address;
                this.managerIds = managerIds;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLogoUrl() {
                return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
        }

        public AddressDTO getAddress() {
                return address;
        }

        public void setAddress(AddressDTO address) {
                this.address = address;
        }

        public List<Long> getManagerIds() {
                return managerIds;
        }

        public void setManagerIds(List<Long> managerIds) {
                this.managerIds = managerIds;
        }
}
