package br.com.banco.controller;

import java.time.LocalDateTime;

public class ControllerAssistant {

    /**
     * recebe uma String em formato de data e a transforma em LocalDateTime
     * @param string a ser transformada em date time
     * @return LDT apartir de uma string
     * */
    public LocalDateTime dateTimeConverter(String string) {
        return LocalDateTime.parse(string);
    }
}
