package com.example.petapp;

public class DadosCompartilhados {

    public static String usuarioLogado;

    public static String[] usuarios ={"admin","pedro","marcelo","maria","joana"};
    public static String[] senhas ={"123","678","1234","9098","00043"};

    public static int IND_VETOR_PET = 0;
    public static final int TAM_MAX_VETOR_PET = 50;
    public static Pet[] vetorPets = new Pet[TAM_MAX_VETOR_PET];

    public static boolean salvarPet(String nome,String idade){
        if(IND_VETOR_PET >= TAM_MAX_VETOR_PET){
            return false;
        }
        Pet pet = new Pet();
        pet.nome = nome;
        pet.idade = idade;
        vetorPets[IND_VETOR_PET] = pet;
        IND_VETOR_PET++;
        return true;
    }

}
