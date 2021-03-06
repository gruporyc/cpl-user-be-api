/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

package co.cpl.service.impl;

import co.cpl.domain.Users;
import co.cpl.dto.UsersDto;
import co.cpl.service.BusinessManager;
import co.cpl.data.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;


/***
 * Implementation for business manager module
 *
 * @author jmunoz
 *
 */
@Component
public class BussinessManagerImpl implements BusinessManager{

    //private UsersRepository usersRepository;
    private static UsersRepository usersRepository;

    public BussinessManagerImpl() {
        usersRepository = new UsersRepository();
    }

    // All business methods should be implemented here
    // example:
    // @Override
    // public boolean isPayed(String serviceId) {
    //        Optional<Service> service = paymentsRepository.getService(serviceId);
    //        if (service.isPresent()) {
    //            return true;
    //        }
    //        return false;
    //    }

    @Override
    public UsersDto findUserById(String Id) {
        Optional<Users> users = usersRepository.getUsers(Id);
        if (!users.isPresent()) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND); }
        //TODO: Replace this code for mapper approach
        UsersDto response = new UsersDto();
        response.setId(users.get().getId());
        response.setPhone(users.get().getPhone());
        response.setName(users.get().getName());
        response.setLast_name(users.get().getLast_name());
        response.setCity(users.get().getCity());
        response.setCountry(users.get().getCountry());
        response.setImei(users.get().getImei());
        response.setStatus(users.get().getStatus());
        response.setPassword(users.get().getPassword());
        response.setEmail(users.get().getEmail());
        return response;
    }

    @Override
    public Boolean saveUser(UsersDto usersDto) {
        return usersRepository.saveUser(usersDto);
    }

    @Override
    public Boolean updateUser(UsersDto usersDto) {
        return usersRepository.updateUser(usersDto);
    }

    @Override
    public UsersDto login(UsersDto usersDto) {
        Optional<Users> users = usersRepository.login(usersDto);
        if (!users.isPresent()) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND); }
        //TODO: Replace this code for mapper approach
        UsersDto response = new UsersDto();
        response.setId(users.get().getId());
        response.setPhone(users.get().getPhone());
        response.setName(users.get().getName());
        response.setLast_name(users.get().getLast_name());
        response.setCity(users.get().getCity());
        response.setCountry(users.get().getCountry());
        response.setImei(users.get().getImei());
        response.setStatus(users.get().getStatus());
        response.setPassword(users.get().getPassword());
        response.setEmail(users.get().getEmail());
        return response;
    }

}
