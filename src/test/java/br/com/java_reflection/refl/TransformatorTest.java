package br.com.java_reflection.refl;

import br.com.java_reflection.Pessoa;
import br.com.java_reflection.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class TransformatorTest {

    private Pessoa pessoa = new Pessoa(1, "Adriel", "111.111.111-11");

    @Test
    void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // ARRANGE
        Transformator transformator = new Transformator();

        // ACT
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        // ASSERT
        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }
}