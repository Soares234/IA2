package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ScrambleMutation<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public ScrambleMutation(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        for (int i = 0; i < 5; i++) {


            int i1 = ThreadLocalRandom.current().nextInt(0, ind.getNumGenes() - 1);
            int i2 = ThreadLocalRandom.current().nextInt(0, ind.getNumGenes() - 1);

            while (i1 == i2) {
                i1 = ThreadLocalRandom.current().nextInt(0, ind.getNumGenes() - 1);
                i2 = ThreadLocalRandom.current().nextInt(0, ind.getNumGenes() - 1);
            }
            int aux = ind.getGene(i1);
            ind.setGene(i1, ind.getGene(i2));
            ind.setGene(i2, aux);

        }
    }

    @Override
    public String toString() {
  return "ScrambleMutation";
    }
}