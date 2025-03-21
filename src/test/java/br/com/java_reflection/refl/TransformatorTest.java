package br.com.java_reflection.refl;

import br.com.java_reflection.Endereco;
import br.com.java_reflection.Pessoa;
import br.com.java_reflection.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class TransformatorTest {

    private Pessoa pessoa = new Pessoa(1, "Adriel", "111.111.111-11");
    private Endereco endereco = new Endereco("Rua 10", 20);

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

    @Test
    void shouldNotTransform() {
        // ASSERT
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            // ARRANGE
            Transformator transformator = new Transformator();

            // ACT
            transformator.transform(endereco);
        });
    }

    @Test
    void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoaSemCpf = new Pessoa("João");
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);

        Assertions.assertEquals(pessoaSemCpf.getNome(), pessoaDTOSemCpf.getNome());
        Assertions.assertNull(pessoaDTOSemCpf.getCpf());
    }
}