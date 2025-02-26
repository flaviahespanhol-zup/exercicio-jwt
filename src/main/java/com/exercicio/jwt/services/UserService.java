package com.exercicio.jwt.services;

import com.exercicio.jwt.dtos.PostUserDto;
import com.exercicio.jwt.models.Role;
import com.exercicio.jwt.models.User;
import com.exercicio.jwt.repositories.RoleRepository;
import com.exercicio.jwt.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void registerUserService(PostUserDto registerUserDto){
        if (userRepository.findByEmail(registerUserDto.getEmail())){
            throw new RuntimeException("E-mail already exists!");
        }

        User user = new User();
        user.setUsername(registerUserDto.getUsername());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerUserDto.getPassword()));

        Set<Role> roles = registerUserDto.getRoles()
                .stream().map(r -> new Role(r.name())).collect(Collectors.toSet());
        roleRepository.saveAll(roles);

        user.setRoles(roles);
        userRepository.save(user);

    }
}
