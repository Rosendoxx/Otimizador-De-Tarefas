package classes;

import java.util.Objects;
import java.util.Scanner;

public class Tarefa{
	private String nome, descricao;
	private boolean status;
	private static Scanner in = new Scanner(System.in);
	
	public Tarefa(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.status = false;
	}
	
	public Tarefa(String nome, String descricao, boolean status) {
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
	}
	
	public static Tarefa criarTarefa() {
		System.out.println("Digite o nome da tarefa a ser adicionada: ");
        String nome = in.nextLine();
        System.out.println("Digite a descrição da tarefa: ");
        String descricao = in.nextLine();
        Tarefa novaTarefa = new Tarefa(nome, descricao);
        return novaTarefa;
	}
	
	public static void finalizarTarefa(Tarefa tarefa) {
		tarefa.setStatus(true);
		System.out.println("Tarefa finalizada com sucesso, parabéns!");
	}
	
	public void mostrarTarefa(){
		System.out.printf("%s%nDescrição: [ %s ]%n Status:%s%n", getNome(), getDescricao(), ((isStatus()) ? "Concluída" : "Pendente"));
		System.out.println();
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, nome, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome) && status == other.status;
	}

	@Override
	public String toString() {
		return "Tarefa [nome=" + nome + ", descricao=" + descricao + ", status=" + status + "]";
	}
	
}