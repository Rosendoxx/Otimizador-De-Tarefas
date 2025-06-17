import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Tarefa{
    static public ArrayList<Tarefa> lista = new ArrayList<>();
    String nome, descricao;
    boolean status;
    public Tarefa(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.status = false;
    }
    static public Scanner in = new Scanner(System.in);
    static public void main(String[] args){
        int opcao=0;
        carregarTarefas();
        System.out.println("=== SEJA BEM-VINDO AO OTIMIZADOR DE TAREAFAS ===");
        while(opcao!=5){
            menu();
            opcao = in.nextInt(); in.nextLine();
            switch (opcao) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    System.out.println("Tarefas atuais: ");
                    mostrar();
                    break;
                case 4:
                    finalizar();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    salvarTarefas();
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente");
                    break;
            }
        }
        in.close();
    }
    static public void menu(){
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Adicionar tarefa ");
        System.out.println("2 - Remover tarefa ");
        System.out.println("3 - Mostrar tarefas ");
        System.out.println("4 - Alterar status da tarefa ");
        System.out.println("5 - Sair ");
    }
    static public void adicionar(){
        System.out.println("Digite o nome da tarefa a ser adicionada: ");
        String nome = in.nextLine();
        System.out.println("Digite a descrição da tarefa: ");
        String descricao = in.nextLine();
        Tarefa novaTarefa = new Tarefa(nome, descricao);
        lista.add(novaTarefa);
    }
    static public void remover(){
        System.out.println("Digite o nome da tarefa a ser removida: ");
        String nome = in.nextLine();
        for (int i=0; i<lista.size(); i++){
            if(nome.equalsIgnoreCase(lista.get(i).nome)){
                lista.remove(i);
                System.out.println("Tarefa removida");
                break;
            }
            else{
                System.out.println("Tarefa não encontrada");
            }
        }
    }
    static public void mostrar(){
        if (lista.isEmpty()){
            System.out.println("Nenhuma tarefa registrada");
            return;
        }
        for (int i=0; i<lista.size(); i++){
            System.out.println((i+1)+" - "+lista.get(i).nome);
            System.out.println("    Descrição: ["+lista.get(i).descricao+"] Status: "+((lista.get(i).status) ?"Concluída" :"Pendente"));
        }
    }
    static public void finalizar(){
        System.out.println("Digite o nome da tarefa que foi concluída: ");
        String nome = in.nextLine();
        for (int i=0; i<lista.size(); i++){
            if(nome.equalsIgnoreCase(lista.get(i).nome)){
                lista.get(i).status = true;
            }
            else{
                System.out.println("Tarefa não encontrada");
            }
        }
    }
    static public void salvarTarefas(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("tarefas.txt"))){
            for (int i=0; i<lista.size(); i++){
                writer.println(lista.get(i).nome+";"+lista.get(i).descricao+";"+lista.get(i).status);
            }
            System.out.println("Tarefas salvas com sucesso! ");
        }
        catch (IOException e){
            System.out.println("Erro ao salvar "+e.getMessage());
        }
    }
    static public void carregarTarefas(){
        lista.clear();
        try(Scanner leitor = new Scanner(new File("tarefas.txt"))){
            while(leitor.hasNextLine()){
                String linha = leitor.nextLine();
                String partes[] = linha.split(";");
                if (partes.length==3){
                    Tarefa t = new Tarefa(partes[0], partes[1]);
                    t.status = Boolean.parseBoolean(partes[2]);
                    lista.add(t);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado "+e.getMessage());
        }
    }
}