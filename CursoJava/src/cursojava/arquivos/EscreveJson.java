package cursojava.arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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
		
		String caminho = "C:\\Users\\ruvia\\git\\repository\\CursoJava\\src\\cursojava\\arquivos\\file_json.json";
		FileWriter fileWriter = new FileWriter(caminho);
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		
		/*** --------- Lendo arquivo Json ------------***/
		FileReader fileReader = new FileReader(caminho);
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		for (JsonElement jsonElement : jsonArray) {
			Usuario usu = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usu);
		}
		System.out.println("leitura do arquivo Json: " + listUsuarios);
	}

}
