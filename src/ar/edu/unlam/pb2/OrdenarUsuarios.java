package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenarUsuarios implements Comparator<Usuario> {

	@Override
	public int compare(Usuario usuario1, Usuario usuario2) {
        return usuario1.getNombre().compareTo(usuario2.getNombre());
	}

}
