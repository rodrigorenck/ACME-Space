package model;

import model.espaconave.*;
import model.espacoporto.ConglomeradoEspacoPorto;
import model.espacoporto.EspacoPorto;
import model.transporte.Transporte;
import model.transporte.TransporteDeMateriais;
import model.transporte.TransporteDePessoas;

import java.io.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Sistema {

    private final ConglomeradoEspacoPorto conglomeradoEspacoPorto = new ConglomeradoEspacoPorto();
    private final ConglomeradoEspaconave conglomeradoEspaconave = new ConglomeradoEspaconave();
    private final Queue<Transporte> filaTransportes = new ArrayDeque<>();


    public void carregarDadosIniciais(String fileName) throws IOException {
        if (fileName.equals("TESTE-espaconaves.dat")) {
            carregarDadosIniciaisEspaconaves(fileName);
        } else if (fileName.equals("TESTE-espacoportos.dat")) {
            carregarDadosIniciaisEspacoportos(fileName);
        } else if (fileName.equals("TESTE-transportes.dat")) {
            carregarDadosIniciaisTransportes(fileName);
        } else {
            throw new FileNotFoundException();
        }
    }

    private void carregarDadosIniciaisTransportes(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String linha = reader.readLine();
        linha = reader.readLine(); //pula a primeira linha
        while (linha != null) {
            var transporte = parseTransporte(linha);
            filaTransportes.add(transporte);
            linha = reader.readLine();
        }
    }

    private void carregarDadosIniciaisEspacoportos(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String linha = reader.readLine();
        linha = reader.readLine(); //pula a primeira linha
        while (linha != null) {
            var espacoPorto = parseEspacoPorto(linha);
            conglomeradoEspacoPorto.cadastra(espacoPorto);
            linha = reader.readLine();
        }
    }

    private void carregarDadosIniciaisEspaconaves(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String linha = reader.readLine();
        linha = reader.readLine(); //pula a primeira linha
        while (linha != null) {
            var espaconave = parseEspaconave(linha);
            conglomeradoEspaconave.cadastra(espaconave);
            linha = reader.readLine();
        }
    }

    private Transporte parseTransporte(String linha) {
        String[] split = linha.split(":");
        var tipo = split[0];
        var espacoPortoOrigemId = split[2];
        var espacoPortoOrigem = conglomeradoEspacoPorto.findById(Integer.parseInt(espacoPortoOrigemId));
        var espacoPortoDestinoId = split[3];
        var espacoPortoDestino = conglomeradoEspacoPorto.findById(Integer.parseInt(espacoPortoDestinoId));
        if (tipo.equals("1")) {
            return new TransporteDePessoas(Integer.parseInt(split[1]), espacoPortoOrigem, espacoPortoDestino, Integer.parseInt(split[4]));
        }
        return new TransporteDeMateriais(Integer.parseInt(split[1]), espacoPortoOrigem, espacoPortoDestino,
                Double.parseDouble(split[4]), split[5]);
    }

    private Espaconave parseEspaconave(String linha) {
        String[] split = linha.split(":");
        var tipo = split[0];
        var espacoPortoId = split[2];
        var espacoPorto = conglomeradoEspacoPorto.findById(Integer.parseInt(espacoPortoId));
        if (tipo.equals("1")) {
            var combustivel = Combustivel.valueOf(split[4].toUpperCase());
            return new Subluz(split[1], espacoPorto, Double.parseDouble(split[3]), combustivel);
        }
        return new FTL(split[1], espacoPorto, Double.parseDouble(split[3]), Integer.parseInt(split[4]));
    }

    private EspacoPorto parseEspacoPorto(String linha) {
        String[] split = linha.split(":");
        return new EspacoPorto(Integer.parseInt(split[0]), split[1],
                Double.parseDouble(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]));
    }

    public List<EspacoPorto> findAllEspacoPortos() {
        return conglomeradoEspacoPorto.findAll();
    }

    public List<Espaconave> findAllEspaconaves() {
        return conglomeradoEspaconave.findAll();
    }

    public Queue<Transporte> findAllTransportes() {
        return filaTransportes;
    }

    public boolean espaconaveExistsBy(String nome) {
        return conglomeradoEspaconave.existsBy(nome);
    }

    public boolean espacoPortoExistsBy(int numero) {
        return conglomeradoEspacoPorto.existsBy(numero);
    }

    public boolean transporteExistsById(int id) {
        for (Transporte t :
                filaTransportes) {
            if (t.getIdentificador() == id) return true;
        }
        return false;
    }

    public EspacoPorto findEspacoportoById(int id){
        return conglomeradoEspacoPorto.findById(id);
    }

    public void cadastrarEspacoporto(EspacoPorto espacoPorto) {
        conglomeradoEspacoPorto.cadastra(espacoPorto);
    }

    public void cadastrarEspaconave(Espaconave espaconave) {
        conglomeradoEspaconave.cadastra(espaconave);
    }

    public void cadastrarTransporte(Transporte transportePessoas) {
        filaTransportes.add(transportePessoas);
    }

    public Espaconave findEspaconaveByName(String nome) {
        return conglomeradoEspaconave.findByName(nome);
    }

    public Transporte findTransporteById(int id) {
        for (Transporte t :
                filaTransportes) {
            if(t.getIdentificador() == id) return t;
        }
        return null;
    }

    public void salvarDados(String nomeArquivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
        for (EspacoPorto p :
                conglomeradoEspacoPorto.findAll()) {
            writer.write(p.toString());
        }
        for (Espaconave e :
                conglomeradoEspaconave.findAll()) {
            writer.write(e.toString());
        }
        for (Transporte t :
                filaTransportes) {
            writer.write(t.toString());
        }
        writer.close();
    }

    public void carregarDados(String nome) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nome));
        var linha =reader.readLine();
        while(linha != null){
            linha = reader.readLine();
        }
    }
}
