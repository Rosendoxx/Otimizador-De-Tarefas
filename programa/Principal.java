package programa;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Arquivo;
import classes.Tarefa;

public class Principal {
	private static ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Arquivo.carregarTarefas("tarefas.txt", lista);
		
		System.out.println("==== SEJA BEM VINDO AO OTIMIZADOR DE TAREFAS ====");
		int opcao=0;
		while(opcao!=5) {
			menu();
			opcao=in.nextInt(); in.nextLine();
			switch(opcao) {
				case 1:
					lista.add(Tarefa.criarTarefa());
					break;
				case 2:
					remover();
					break;
				case 3:
					mostrar(lista);
					break;
				case 4:
					finalizar();
					break;
				case 5:
					Arquivo.salvarTarefas("tarefas.txt", lista);
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida, digite novamente!");
					break;
			}
		}
	}
	
    static public void menu(){
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Adicionar tarefa ");
        System.out.println("2 - Remover tarefa ");
        System.out.println("3 - Mostrar tarefas ");
        System.out.println("4 - Finalizar tarefa ");
        System.out.println("5 - Sair ");
    }
    
    static public void mostrar(ArrayList<Tarefa> lista) {
    	if(lista.isEmpty()) {
    		System.out.println("Nenhuma tarefa adicionada");
    		return;
    	}
    	for(Tarefa t : lista) {
    		System.out.printf("%d - %s%n", lista.indexOf(t)+1, t.getNome());
    		t.mostrarTarefa();
    	}
    }
    static public void remover() {
    	System.out.println("Digite o ID da tarefa a ser removida:");
    	int id = in.nextInt(); in.nextLine();
    	boolean encontrado=false;
    	for(Tarefa t : lista) {
    		if(lista.indexOf(t)==(id-1)){
    			encontrado=true;
    			lista.remove(t);
    			System.out.println("Tarefa removida!");
    			break;
    		}
    	}
    	if(!encontrado) {
    		System.out.println("Tarefa não encontrada!");
    	}
    }
    
    static public void finalizar() {
    	System.out.println("Digite o ID da tarefa que foi finalizada:");
    	int id = in.nextInt(); in.nextLine();
    	boolean encontrado=false;
    	for(Tarefa t : lista) {
    		if(lista.indexOf(t)==(id-1)){
    			encontrado=true;
    			Tarefa.finalizarTarefa(t);
    			break;
    		}
    	}
    	if(!encontrado) {
    		System.out.println("Tarefa não encontrada!");
    	}
    }
}
