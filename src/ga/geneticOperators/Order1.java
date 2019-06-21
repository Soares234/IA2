package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Order1<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Order1(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {
        int tamanhoInd = ind1.getNumGenes();
        int[] c1 = new int[ind1.getNumGenes()];
        LinkedList<Integer> listaUsados = new LinkedList<>();
        //Cria 2 ints random de 0 a tamanho max
        int corteInicio = ThreadLocalRandom.current().nextInt(0, tamanhoInd - 3);
        int corteFim = ThreadLocalRandom.current().nextInt(corteInicio + 2, tamanhoInd - 1);
        //Fim 2 random ints
        //Copia corte
        for (int i = corteInicio + 1; i < corteFim; i++) {
            c1[i] = ind1.getGene(i);
            listaUsados.add(ind1.getGene(i));
        }
        //Fim copia corte
        //Inicio resto
        for (int i = corteFim; i < c1.length; i++) {

            if (!listaUsados.contains(ind2.getGene(i))) {
                c1 = adicionarFilho(c1, ind2.getGene(i));
                listaUsados.add(ind2.getGene(i));
            }

            if (c1[c1.length - 1] != 0) {
                break;
            }

            if (i == ind1.getNumGenes() - 1) {
                i = -1;
            }

        }
        //Fim resto
        for (int i = 0; i < c1.length; i++) {
            ind1.setGene(i, c1[i]);
        }

        listaUsados.clear();
    }

    public int[] adicionarFilho(int[] c1, int valor){
        for (int i = 0; i < c1.length; i++) {
            if (c1[i]==0) {
                c1[i]=valor;
                break;
            }
        }

        return c1;
    }
    @Override
    public String toString(){
        return "Order1";
    }    
}