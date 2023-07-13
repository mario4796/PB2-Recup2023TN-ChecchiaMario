package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestSistema {

	@Test
	public void queSePuedaCrearUnUsuario() {
		Sistema sistema = new Sistema();
		//Usuario(nombre,contraseña,intentos)
		Usuario usuario1 = new Usuario("Carlos","A1",2,TipoDeUsuario.BASICO);
		Usuario usuario2 = new Usuario("Jose","Fds123",1,TipoDeUsuario.ADMINISTRADOR);
		
		Integer cantidadEsperada = 2;
		
		sistema.agregarUsuario(usuario1);
		sistema.agregarUsuario(usuario2);
		
		assertEquals(cantidadEsperada,sistema.cantUsuarios());
	}
	
	@Test
	public void queAlIingresarLacontraseñaMasDe3VecesSeBloquee() {
		Sistema sistema = new Sistema();
		//Usuario(nombre,contraseña,intentos)
		Usuario usuario1 = new Usuario("Carlos","A1",5,TipoDeUsuario.BASICO);
		Usuario usuario2 = new Usuario("Jose","Fds123",1,TipoDeUsuario.ADMINISTRADOR);
		
		
		Integer cantidadEsperada = 1;
		
		sistema.agregarUsuario(usuario1);
		sistema.agregarUsuario(usuario2);
		
		assertEquals(cantidadEsperada,sistema.cantUsuariosBloqueados());
	}
	
    @Test (expected = UserNotFound.class)
    public void queSiSeIntentaLoguearUnUsuarioNoRegistradoSeProduzcaUnaExcepcion() throws UserNotFound{
    	Sistema sistema = new Sistema();
		//Usuario(nombre,contraseña,intentos)
		Usuario usuario1 = new Usuario("Carlos","A1",5,TipoDeUsuario.BASICO);
		Usuario usuario2 = new Usuario("Jose","Fds123",1,TipoDeUsuario.ADMINISTRADOR);
		Usuario usuario3 = new Usuario("Enzo","1234",2,TipoDeUsuario.BASICO);
		
		Integer cantidadEsperada = 2;
		
		sistema.agregarUsuario(usuario1);
		sistema.agregarUsuario(usuario2);
		
		sistema.noRegistrado(usuario3);
		
    }
    
    @Test
    public void queSePuedanOrdenarLosUsuariosAlfabeticamente() {
    	Sistema sistema = new Sistema();
		//Usuario(nombre,contraseña,intentos)
		Usuario usuario1 = new Usuario("Carlos","A1",2,TipoDeUsuario.BASICO);
		Usuario usuario2 = new Usuario("Jose","Fds123",1,TipoDeUsuario.ADMINISTRADOR);
		Usuario usuario3 = new Usuario("Enzo","1234",2,TipoDeUsuario.BASICO);
		
		Integer cantidadEsperada = 2;
		
		sistema.agregarUsuario(usuario1);
		sistema.agregarUsuario(usuario2);
		sistema.agregarUsuario(usuario3);
		
		List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario3);
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        OrdenarUsuarios comparar = new OrdenarUsuarios();
        Collections.sort(usuarios, comparar);
		
        for (Usuario usuario : usuarios) {
		        System.out.println(usuario.getNombre());
		    }
		
    }
    
        
 }
