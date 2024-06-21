package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jogador {

    public List<Carta> cartas;

    public String nome;

    public Jogador(String nome) {
        this.cartas = new ArrayList<>();
        this.nome = nome;
    }

    public Carta jogada(Carta cartaNaMesa){
      
      // Jogada com 3 cartas na mão
    if (cartas.size() == 3) {
        if (cartaNaMesa == null) {
            // Se não há carta na mesa, joga a maior carta
            Carta maiorCarta = Collections.max(cartas, Comparator.comparingInt(c -> c.valor));
            cartas.remove(maiorCarta);
            return maiorCarta;
        } else {
            // Tenta achar uma carta de valor maior
            Carta cartaMaior = null;
            Carta cartaMenor = cartas.get(0);
            for (Carta carta : cartas) {
                if (carta.valor > cartaNaMesa.valor) {
                    if (cartaMaior == null || carta.valor < cartaMaior.valor) {
                        cartaMaior = carta;
                    }
                }
                if (carta.valor < cartaMenor.valor) {
                    cartaMenor = carta;
                }
            }
            if (cartaMaior != null) {
                cartas.remove(cartaMaior);
                return cartaMaior;
            }
            cartas.remove(cartaMenor);
            return cartaMenor;
        }
    }
    
    // Jogada com 2 cartas na mão
    if (cartas.size() == 2) {
        if (cartaNaMesa == null) {
            // Se não há carta na mesa, joga a maior carta
            Carta maiorCarta = Collections.max(cartas, Comparator.comparingInt(c -> c.valor));
            cartas.remove(maiorCarta);
            return maiorCarta;
        } else {
            // Tenta achar uma carta de valor maior
            Carta cartaMaior = null;
            Carta cartaMenor = cartas.get(0);
            for (Carta carta : cartas) {
                if (carta.valor > cartaNaMesa.valor) {
                    if (cartaMaior == null || carta.valor < cartaMaior.valor) {
                        cartaMaior = carta;
                    }
                }
                if (carta.valor < cartaMenor.valor) {
                    cartaMenor = carta;
                }
            }
            if (cartaMaior != null) {
                cartas.remove(cartaMaior);
                return cartaMaior;
            }
            cartas.remove(cartaMenor);
            return cartaMenor;
        }
    }
    
    // Jogada com 1 carta na mão
    if (cartas.size() == 1) {
        // Joga a única carta que tem
        return cartas.remove(0);
    }
    
    // Se não houver cartas na mão, retorna null 
    return null;
}



    public void exibeCartas(){
        cartas.forEach(c -> {
            System.out.print(c + " ");
        });
        System.out.println();
    }
}
