/*
 7. Escreva o método de remoção para uma lista ordenada implementada em
vetores. Seu método de remoção deverá utilizar um método de busca binária
para verificar se o elemento existe ou não. Caso o elemento exista a sua
busca binária deverá retornar a posição do elemento a ser removido.
 */
package br.rogerio.model;

/**
 *
 * @author roger
 */
public class Lista {

    private final int MAXTAM;
    private int array[];
    private int ultimo;

    public Lista(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho deve ser maior que zero!\n");
        }
        MAXTAM = tamanho;
        array = new int[MAXTAM];
        ultimo = -1;
    }

    public boolean isEmpty() {
        return ultimo == -1;
    }

    public boolean isFull() {
        return ultimo + 1 == MAXTAM;
    }

    public int size() {
        return ultimo + 1;
    }

    public void insereInicio(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        for (int i = ultimo; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = elemento;
    }

    public void ordenarLista() {
        for (int i = 0; i < ultimo; i++) {
            for (int j = i + 1; j < ultimo + 1; j++) {
                if (array[i] > array[j]) {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }

    }

    public void inserirDeFormaOrdenada(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia");
        }
        ultimo++;
        int i = ultimo;
        while ((i > 0) && (elemento < array[i - 1])) {
            array[i] = array[i - 1];
            i--;
        }
        array[i] = elemento;
    }

    public void mostrarLista() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        System.out.println("*****  Elementos da Lista  *****");
        for (int i = 0; i <= ultimo; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println("");
    }

    public void insereFim(int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        array[ultimo] = elemento;
    }

    public void inserePosicao(int posicao, int elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        if (posicao > ultimo + 1 || posicao < 0) {
            throw new RuntimeException("Posição inválida!\n");
        }
        ultimo++;
        for (int i = ultimo; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
    }

    public void removeInicio() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        for (int i = 0; i < 10; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public void removeFim() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        ultimo--;
    }

    public void removePosicao(int posicao) {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        if (posicao < 0 || posicao > ultimo) {
            throw new RuntimeException("Posição inválida!\n");
        }
        for (int i = posicao; i < ultimo; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    //retorna a posição do elemento, caso o elemento exista
    //retorna -1, caso contrário elemento não exista
    public int buscaElemento(int elemento) {
        for (int i = 0; i < ultimo; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    //retorna true, caso o elemento seja removido
    //ou retorna false, caso contrário, se o elemento não foi removido
    public boolean removeElemento(int elemento) {
        int pos = buscaElemento(elemento);
        if (pos == -1) {
            return false;
        }
        removePosicao(pos);
        return true;
    }

    public int getInicio() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        return array[0];
    }

    public int getFim() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        return array[ultimo];
    }

    public int getPosicao(int posicao) {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        if (posicao > ultimo || posicao < 0) {
            throw new RuntimeException("Posição inválida!\n");
        }
        return array[posicao];
    }

    //tornando a lista vazia
    public void destroy() {
        ultimo = -1;
    }

    public void RemoverComVerificacaoDoBuscaBinaria(int elemento) {

        int posicao = BuscaBinaria(elemento);

        if (posicao == -1) {
            throw new RuntimeException("O elemento informado pelo usuário não existe");
        }

        removePosicao(posicao);

    }

    public int BuscaBinaria(int numero) {

        int inicio = 0;
        int fim = ultimo + 1;
        int meio = (inicio + fim) / 2;
        int posicao = 0;
        boolean localizador = false;
        while (inicio <= fim && localizador == false) {
            if (array[meio] == numero) {
                posicao = meio;
                localizador = true;
                
            } else {
                if (numero < array[meio]) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
                meio = (inicio + fim) / 2;
            }
        }

        meio = (inicio + fim) / 2;
        if (localizador) {
            return posicao;
        } else {
            return -1;
        }
    }
}
