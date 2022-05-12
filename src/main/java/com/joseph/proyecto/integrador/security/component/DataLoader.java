package com.joseph.proyecto.integrador.security.component;



import com.joseph.proyecto.integrador.security.entity.Usuario;
import com.joseph.proyecto.integrador.security.entity.UsuarioRoles;
import com.joseph.proyecto.integrador.security.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String pass1= passwordEncoder.encode("1234");
        String pass2= passwordEncoder.encode("12345");

        usuarioRepository.save(new Usuario("Joseph","Joseph","jhos92@hotmail.com", pass1, UsuarioRoles.ROLE_ADMIN));
        usuarioRepository.save(new Usuario("Pepe","Perez","ejemplo@mail.com", pass2, UsuarioRoles.ROLE_USER));
    }
}
