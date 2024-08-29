package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.repositories.AddressRepository;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("Request to save: {}", addressDTO );
        Address address = AddressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return AddressMapper.fromEntity(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        log.debug("Request to update: {}", addressDTO);
        return findOne(addressDTO.getId_addess()).map(existingAddress ->{
             existingAddress.setCountry(addressDTO.getCountry());
            existingAddress.setCity(addressDTO.getCity());
            return save(addressDTO);
        }).orElseThrow(() ->new IllegalArgumentException());

    }

    @Override
    public Optional<AddressDTO> findOne(Long id_address) {
        //La map se comporte ici comme une fonction lambda
        log.debug("Resquest to get id: {}", id_address);
        //avec le optional on accède directement à map
        return addressRepository.findById(id_address).map(address ->{
            return AddressMapper.fromEntity(address);
        });
    }

    @Override
    public List<AddressDTO> findAll() {
        //stream permet d'avoir accès à plusieurs méthodes
        //Pour accéder à la map ic il faut passer par stream
        //Le tream joue le rôle de list lorsqu'il s'agit  d'une liste
        return addressRepository.findAll().stream().map(address -> {
            return AddressMapper.fromEntity(address);
        }).toList();
    }

    @Override
    public void delete(Long id_address) {
        addressRepository.deleteById(id_address);
    }
}
