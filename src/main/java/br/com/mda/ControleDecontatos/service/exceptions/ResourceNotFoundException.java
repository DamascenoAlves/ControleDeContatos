package br.com.mda.ControleDecontatos.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg){
        super (msg);
    }
}