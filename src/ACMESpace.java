
import model.*;
import model.espaconave.Espaconave;
import model.espaconave.FTL;
import model.espaconave.Subluz;
import model.espacoporto.EspacoPorto;
import model.transporte.StatusTransporte;
import model.transporte.Transporte;
import model.transporte.TransporteDeMateriais;
import model.transporte.TransporteDePessoas;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/**
 * Autores: Rodrigo Renck, Arthur Bonazzi, Enrico Cidade
 */
public class ACMESpace {

    private Scanner sc;
    private Scanner scStr;
    private Sistema sistema;

    public ACMESpace(){
        scStr = new Scanner(System.in);
        sc = new Scanner(System.in);
        sistema = new Sistema();
    }



    public void run() {
        int opcao;
        try {
            do {
                menu();
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1 -> cadastrarEspacoPorto();
                    case 2 -> cadastrarEspaconave();
                    case 3 -> cadastrarTransporte();
                    case 4 -> consultarTodosTransportes();
                    case 5 -> alterarEstadoTransporte();
                    case 6 -> carregarDadosIniciais();
                    case 7 -> designarTransportes();
                    case 8 -> salvarDados();
                    case 9 -> carregarDados();
                    case 10 -> encerrar();
                }
            } while (opcao != 10);
        }catch (InputMismatchException e){
            System.err.println("Erro! Formato de entrada invalido");
        }
    }

    //**
    private void carregarDados() {
        System.out.println("\n[CARREGAR DADOS]");
        System.out.println("Informe o nome do arquivo sem extensao: ");
        var nome = scStr.nextLine();
        try{
            sistema.carregarDadosIniciais(nome);
        }catch (Exception e){
            System.err.println("Erro ao carregar os dados do arquivo");
        }
    }

    private void salvarDados() {
        System.out.println("\n[SALVAR DADOS]");
        System.out.println("Informe o nome do arquivo sem extensao: ");
        var nomeArquivo = scStr.nextLine();
        try{
            sistema.salvarDados(nomeArquivo);
        }catch (Exception e){
            System.err.println("Erro ao salvar os dados no arquivo");
        }
    }

    private void alterarEstadoTransporte() {
        System.out.println("\n[ALTERAR ESTADO DO TRANSPORTE]");
        System.out.print("Informe o identificador do transporte: ");
        var id = sc.nextInt();
        var transp = sistema.findTransporteById(id);
        if(transp == null){
            System.err.println("Erro transporte nao encontrado!");
            return;
        }
        if(transp.getStatus() == StatusTransporte.CANCELADO || transp.getStatus() == StatusTransporte.FINALIZADO){
            System.err.println("Erro transporte de estado cancelado ou finalizado nao pode ser alterado");
            return;
        }
        System.out.print("Informe o novo estado: ");
        var novo = StatusTransporte.valueOf(scStr.nextLine().toUpperCase());
        transp.setStatus(novo);
        System.out.println("Estado do transporte atualizado com sucesso!");
    }

    private void designarTransportes() {
        System.out.println("\n[DESIGNAR TRANSPORTES]");
        List<Espaconave> allEspaconaves = sistema.findAllEspaconaves();
        Queue<Transporte> allTransportes = sistema.findAllTransportesPendentes();
        if(allTransportes.isEmpty()){
            System.err.println("Erro! Nao ha transportes");
            return;
        }
        //pega o primeiro da fila
        var transporte = allTransportes.remove();
        System.out.println(transporte);

        System.out.println("ESPACONAVES DISPONIVEIS");
        allEspaconaves.forEach(System.out::println);


        System.out.println("Informe o nome da espaconave desejada");
        var nome = scStr.nextLine();
        Espaconave espaconave = sistema.findEspaconaveByName(nome);
        if(espaconave == null){
            System.err.println("Espaconave desejada nao encontrada");
            return;
        }
        if(espaconave instanceof Subluz){
            espaconave.designarParaTransporte(transporte);
            System.out.println("Transporte cadastrado com sucesso");
            return;
        }
        if(espaconave instanceof FTL){
            int p = 0;
            double l = ((FTL) espaconave).getLimiteTransporte();
            double c = 0;
            if(transporte instanceof TransporteDePessoas){
                p = ((TransporteDePessoas) transporte).getQuantidadePessoasTransportadas();
            }else if(transporte instanceof TransporteDeMateriais){
                c = ((TransporteDeMateriais) transporte).getCarga();
            }
            if(l > p && l > c){
                espaconave.designarParaTransporte(transporte);
                System.out.println("Transporte cadastrado com sucesso");
            }else{
                System.out.println("Erro ao cadastrar o transporte!");
            }
        }

    }

    private void consultarTodosTransportes() {
        System.out.println("\n[CONSULTAR TODOS TRANSPORTES]");
        List<Transporte> allTransportes = sistema.findAllTransportes();
        if(allTransportes.isEmpty()){
            System.err.println("Erro! Nao ha transportes");
            return;
        }
        allTransportes.forEach(System.out::println);
    }

    private void cadastrarTransporte() {
        System.out.println("\n[CADASTRAR TRANSPORTE]");
        System.out.println("Preencha os dados abaixo");
        System.out.print("Identificador: " );
        var id = sc.nextInt();
        if(sistema.transporteExistsById(id)){
            System.err.println("Erro! Transporte com o identificador indicado ja existe");
            return;
        }
        System.out.print("Numero do espaco porto de origem: ");
        var espOrigem = sc.nextInt();
        System.out.print("Numero do espaco porto de destino: ");
        var espDestino = sc.nextInt();

        EspacoPorto origem = sistema.findEspacoportoById(espOrigem);
        EspacoPorto destino = sistema.findEspacoportoById(espDestino);
        if(origem == null || destino == null){
            System.err.println("Erro! Espaco portos indicados invalidos");
            return;
        }

        System.out.println("Tipo do transporte: ");
        var resp = 0;
        do {
            System.out.println("Digite [1] para PESSOAS");
            System.out.println("Digite [2] para MATERIAIS");
            resp = sc.nextInt();
        }while(resp != 1 && resp !=2);
        if(resp == 1){
            cadastraTransportePessoas(id, origem, destino);
        }else{
            cadastraTransporteMateriais(id, origem, destino);
        }
    }

    private void cadastraTransporteMateriais(int id, EspacoPorto origem, EspacoPorto destino) {
        System.out.println("CADASTRA TRANSPORTE MATERIAIS");
        System.out.print("Informe a descricao: ");
        var desc = scStr.nextLine();
        System.out.print("Informe a carga: ");
        var carga = sc.nextDouble();
        var transporteMateriais = new TransporteDeMateriais(id, origem, destino, carga, desc);
        sistema.cadastrarTransporte(transporteMateriais);
        System.out.println(transporteMateriais);
    }

    private void cadastraTransportePessoas(int id, EspacoPorto origem , EspacoPorto destino) {
        System.out.println("CADASTRA TRANSPORTES PESSOAS");
        System.out.print("Informe a quantidade de pessoas: ");
        var quant = sc.nextInt();
        var transportePessoas = new TransporteDePessoas(id, origem, destino, quant);
        sistema.cadastrarTransporte(transportePessoas);
        System.out.println(transportePessoas);
    }

    private void carregarDadosIniciais() {
        System.out.println("\n[CARREGAR DADOS INICIAIS]");
        System.out.println("[Sugestao comece carregando o arquivo dos Espaco Portos]");
        System.out.print("Informe o nome do arquivo sem extensao: ");
        String nomeArquivo = scStr.nextLine().concat(".dat");
        try{
            sistema.carregarDadosIniciais(nomeArquivo);
            System.out.println("\nCarregando...");
            System.out.println("Dados carregados com sucesso!");
            System.out.println("\nESPACO-PORTOS");
            var espacosPortos = sistema.findAllEspacoPortos();
            espacosPortos.forEach(System.out::println);

            System.out.println("\nESPACONAVES");
            var espaconaves = sistema.findAllEspaconaves();
            espaconaves.forEach(System.out::println);

            System.out.println("\nFILA DE TRANSPORTES");
            var transportes = sistema.findAllTransportesPendentes();
            transportes.forEach(System.out::println);

        }catch (Exception e) {
            System.err.println("Erro ao carregar dados iniciais");
//            e.printStackTrace();
        }
    }

    private void cadastrarEspaconave() {
        System.out.println("\n[CADASTRAR ESPACO-NAVE]");
        System.out.println("Preencha os dados abaixo");
        System.out.print("Nome: ");
        String nome = scStr.nextLine();
        if(sistema.espaconaveExistsBy(nome)){
            System.err.println("Erro! Espaconave com o nome indicado ja existe!");
            return;
        }
        Espaconave espaconave = new Espaconave(nome);
        sistema.cadastrarEspaconave(espaconave);
        System.out.println("Espaconave cadastrada com sucesso!");
    }

    private void cadastrarEspacoPorto() {
        System.out.println("\n[CADASTRAR ESPACO-PORTO]");
        System.out.println("Preencha os dados abaixo");
        System.out.print("Numero: ");
        int numero = sc.nextInt();
        if(sistema.espacoPortoExistsBy(numero)){
            System.err.println("Erro! Espaco porto com o numero indicado ja existe!");
            return;
        }
        System.out.print("Nome: ");
        String nome = scStr.nextLine();
        System.out.print("Coordenada X: ");
        double x = sc.nextDouble();
        System.out.print("Coordenada Y: ");
        double y = sc.nextDouble();
        System.out.print("Coordenada Z: ");
        double z = sc.nextDouble();
        sistema.cadastrarEspacoporto(new EspacoPorto(numero, nome, x, y, z));
        System.out.println("Espaco porto cadastrado com sucesso!");
    }

    private void encerrar() {
        System.out.println("Encerrando o programa...");
    }

    public void menu(){
        System.out.println("-----------------------");
        System.out.println("\tACME-SPACE");
        System.out.println("-----------------------");
        System.out.println("[1] Cadastrar novo Espaco Porto");
        System.out.println("[2] Cadastrar nova Espaco Nave");
        System.out.println("[3] Cadastrar novo Transporte");
        System.out.println("[4] Consultar todos os Transportes");
        System.out.println("[5] Alterar estado de transporte");
        System.out.println("[6] Carregar dados iniciais");
        System.out.println("[7] Designar transportes");
        System.out.println("[8] Salvar dados");
        System.out.println("[9] Carregar dados");
        System.out.println("[10] Encerrar a aplicacao");
        System.out.print("Opcao desejada: ");
    }
}
