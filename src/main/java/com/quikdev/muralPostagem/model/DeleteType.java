package com.quikdev.muralPostagem.model;

public enum DeleteType {
	
    USER("Comentário deletado pelo usuário do comentário"), 
    OWNER("Comentário deletado pelo usuário da postagem");
	
    public final String label;

    private DeleteType(String label) {
        this.label = label;
    }
}
