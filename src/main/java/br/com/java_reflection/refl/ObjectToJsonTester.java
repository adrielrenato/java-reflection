package br.com.java_reflection.refl;

import br.com.java_reflection.Pessoa;

public class ObjectToJsonTester {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1, "Adriel", "111.111.111-11");
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
        Pessoa pessoaSemCpf = new Pessoa("João");
        System.out.println(objectToJson.transform(pessoaSemCpf));
    }
}
