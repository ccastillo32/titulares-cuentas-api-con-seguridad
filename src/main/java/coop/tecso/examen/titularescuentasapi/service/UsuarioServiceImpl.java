package coop.tecso.examen.titularescuentasapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.tecso.examen.titularescuentasapi.dto.UsuarioDto;
import coop.tecso.examen.titularescuentasapi.model.Rol;
import coop.tecso.examen.titularescuentasapi.model.Usuario;
import coop.tecso.examen.titularescuentasapi.repository.RolRepository;
import coop.tecso.examen.titularescuentasapi.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioDao;
	
	@Autowired
	private RolRepository rolDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("El usuario " + username + " no existe");
		}
		
		System.out.println("Roles: " + usuario.getRoles().size());
		for(Rol rol : usuario.getRoles()) {
			System.out.println(rol.getNombre());
		}
		System.out.println("Password: " + usuario.getPassword());
		
		List<GrantedAuthority> roles = usuario.getRoles()
                							  .stream()
                							  .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                							  .collect(Collectors.toList());
		
		return new User(username, usuario.getPassword(), usuario.isHabilitado(), true, true, true, roles);
	}

    @Override
    @Transactional
    public boolean crearUsuario(UsuarioDto dto) {
        boolean registrado = false;
        try {
            
            String username = dto.getUsername();
            String password = dto.getPassword();
            
            if(username == null || password == null) {
                throw new CampoIncorrectoException("El username y el password son obligatorios");
            }
            
            Usuario usuario = usuarioDao.findByUsername(username);
            if(usuario != null) {
                throw new CampoIncorrectoException("El username " + username + " no está disponible" );
            }
            
            Rol rol = rolDao.findByNombre("ROLE_USER");
            List<Rol> roles = new ArrayList<>();
            roles.add(rol);
            
            Usuario entity = new Usuario();
            entity.setUsername(username);
            entity.setPassword(passwordEncoder.encode(password));
            entity.setHabilitado(true);
            entity.setNombre(dto.getNombre());
            entity.setApellido(dto.getApellido());
            entity.setRoles(roles);
            
            usuarioDao.save(entity);
            System.out.println("Creado con el id: " + entity.getId());
            registrado = entity.getId() != null;
            
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new UsuarioServiceException("Error creando el usuario", exp);
        }
        return registrado;
    }

}
