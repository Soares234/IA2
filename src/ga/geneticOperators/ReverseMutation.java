package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ReverseMutation<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public ReverseMutation(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        int tamanhoInd =  ind.getNumGenes();
        int corteInicio = ThreadLocalRandom.current().nextInt(0,tamanhoInd-3);
        int corteFim = ThreadLocalRandom.current().nextInt(corteInicio+2,tamanhoInd-1);
        int vetorAux[] = new int[corteFim-corteInicio];

        for (int i = corteFim; i > corteInicio ; i--) {
            vetorAux[corteFim-i]=ind.getGene(i);
        }
        for (int i = corteInicio+1; i < corteFim; i++) {
            ind.setGene(i,vetorAux[i-corteInicio]);
        }



    }

    @Override
    public String toString() {
        //TODO
        return "Reverse Mutation";
    }
}