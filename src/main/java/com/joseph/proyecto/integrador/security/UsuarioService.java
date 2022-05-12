package com.joseph.proyecto.integrador.security;



import com.joseph.proyecto.integrador.security.entity.Usuario;
import com.joseph.proyecto.integrador.security.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Usuario> usuarioBuscado = usuarioRepository.findByEmail(username);
            if (usuarioBuscado.isPresent()){
                return usuarioBuscado.get();
            }
            else {
                throw new UsernameNotFoundException("Email de usuario no encontrado");
            }
        }
    }

