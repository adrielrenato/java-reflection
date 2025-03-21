package br.com.java_reflection;

import br.com.java_reflection.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {
    public PessoaDto list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDto dto = new Transformator().transform(pessoa);

        return dto;
    }
}
