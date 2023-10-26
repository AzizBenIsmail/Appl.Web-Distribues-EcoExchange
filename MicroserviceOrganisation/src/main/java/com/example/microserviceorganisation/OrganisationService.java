package com.example.microserviceorganisation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {
    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    WebClient webClient;

    @Autowired
    UserClient userClient;
    @Autowired
    private ModelMapper mapper;

    public Organisation AddOrganisation(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public Organisation updateOrganisation(int id, Organisation newOrganisation) {

        if (organisationRepository.findById(id).isPresent()) {
            Organisation existingOrganisation = organisationRepository.findById(id).get();
            existingOrganisation.setTitle(newOrganisation.getTitle());
            existingOrganisation.setDescription(newOrganisation.getDescription());
            existingOrganisation.setCategory(newOrganisation.getCategory());
            return organisationRepository.save(existingOrganisation);
        } else
            return null;
    }

    public String deleteOrganisation(int id) {
        if (organisationRepository.findById(id).isPresent()) {
            organisationRepository.deleteById(id);
            return "Organisation supprimé";
        } else
            return "Organisation non supprimé";
    }

    public List<Organisation> getAllOrganisation() {
        return organisationRepository.findAll();
    }

    public Organisation getOrganisationById(int id) {
        return organisationRepository.findById(id).orElse(null);
    }

    public UserResponse getUserById(long userId){
        Mono<UserResponse> userResponse= webClient.get().uri("/"+userId).retrieve().bodyToMono(UserResponse.class);
        return userResponse.block();
    }


}
