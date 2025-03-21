package br.com.java_reflection;

import br.com.java_reflection.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {
    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO dto = new Transformator().transform(pessoa);

        return dto;
    }
}
