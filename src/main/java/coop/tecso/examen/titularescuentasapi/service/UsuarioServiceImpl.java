package coop.tecso.examen.titularescuentasapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.tecso.examen.titularescuentasapi.model.Rol;
import coop.tecso.examen.titularescuentasapi.model.Usuario;
import coop.tecso.examen.titularescuentasapi.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioDao;
	
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

}
