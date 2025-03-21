package br.com.java_reflection.refl;

import br.com.java_reflection.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectToJsonTest {
    Pessoa pessoa = new Pessoa(1, "João", "111.111.111-11");

    @Test
    public void shouldTransform() {
        ObjectToJson objectToJson = new ObjectToJson();
        String actual = objectToJson.transform(pessoa);

        System.out.println(actual);

        Assertions.assertInstanceOf(String.class, actual);
    }
}