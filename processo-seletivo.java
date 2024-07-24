package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativas = 1;
        boolean tentarNovamente = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            tentarNovamente = !atendeu;
            if (tentarNovamente) {
                tentativas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO.");
            }
        } while (tentarNovamente && tentativas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA TENTATIVA " + tentativas);
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO"};

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("Candidato " + (indice + 1) + ": " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELE", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou como salário o valor de " + salarioPretendido + " reais");
            if (salarioBase >= salarioPretendido) {
                System.out.println(candidatos[candidatoAtual] + " foi selecionado(a)");
                candidatosSelecionados++;
            } else {
                System.out.println(candidatos[candidatoAtual] + " não foi selecionado(a)");
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("\nLIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("\nLIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("\nAGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
