package ar.edu.unlam.pb2;

import java.util.HashSet;

public class Sistema{

	HashSet<Usuario> usuarios = new HashSet<>();
	HashSet<Usuario> bloqueados = new HashSet<>();
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public Object cantUsuarios() {
		return usuarios.size();
	}

	public Object cantUsuariosBloqueados() {
		for(Usuario usuario : usuarios) {
			if((usuario.tipoDeUsuario == TipoDeUsuario.BASICO) && (usuario.getIntentos()>=3)) {
				usuarios.remove(usuario);
				bloqueados.add(usuario);
			}
		}
		return bloqueados.size();
	}

	public boolean noRegistrado(Usuario usuario3) throws UserNotFound {
		for(Usuario usuario : usuarios) {
			if(usuarios.contains(usuario3)) {
				return true;
			}
			else {
				throw new UserNotFound("el usuario no se encuentra registrado");
			}
		}
		return false;
		
	}

	
}
