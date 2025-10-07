package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivo {
	static public void salvarTarefas(String nomeArquivo, ArrayList<Tarefa> lista) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));){
			for (int i=0; i<lista.size(); i++) {
                writer.println(lista.get(i).getNome()+";"+lista.get(i).getDescricao()+";"+lista.get(i).isStatus());
			}
			System.out.println("Tarefas salvas com sucesso!");
		} catch(IOException e) {
			System.out.println("Erro ao salvar! "+e.getMessage());
		}
	}
	
	static public ArrayList<Tarefa> carregarTarefas(String nomeArquivo, ArrayList<Tarefa> lista) {
		lista.clear();
		
		
		try(Scanner leitor = new Scanner(new File(nomeArquivo))){
			while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String partes[] = linha.split(";");
                if (partes.length==3){
                    Tarefa t = new Tarefa(partes[0], partes[1], Boolean.parseBoolean(partes[2]));
                    lista.add(t);
                }
			}
		} catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado "+e.getMessage());
		}
		return lista;
	}
}