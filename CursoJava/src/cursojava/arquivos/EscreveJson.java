package cursojava.arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJson {

	public static void main(String[] args) throws IOException {
		Usuario usuario = new Usuario();
		usuario.setCpf("00099988877");
		usuario.setLogin("admin");
		usuario.setSenha("1234");
		usuario.setNome("Administrador");
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("12365478");
		usuario1.setLogin("joseé");
		usuario1.setSenha("225566");
		usuario1.setNome("Membro");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("45698712532");
		usuario2.setLogin("Maria");
		usuario2.setSenha("336655");
		usuario2.setNome("VIP");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gsonJ = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gsonJ.toJson(usuarios);//Gson().toJson(usuarios);
		
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\ruvia\\git\\repository\\CursoJava\\src\\cursojava\\arquivos\\file_json.json");
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
	}

}
