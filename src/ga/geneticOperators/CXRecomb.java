package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.module.InvalidModuleDescriptorException;
import java.util.Arrays;
import java.util.LinkedList;

public class CXRecomb<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    LinkedList<Integer> listaIndices= new LinkedList<>();

    //TODO this class might require the definition of additional methods and/or attributes
    public CXRecomb(double probability) {
        super(probability);
    }
    @Override
    public void recombine(I ind1, I ind2) {

        int aux = 0, idx = 0;
        do {
            listaIndices.add(idx);
            aux = ind2.getGene(idx);
            idx = ind1.getIndexof(aux);
        } while (!listaIndices.contains(idx));
        for (int i = 0; i < listaIndices.size(); i++) {
            aux=ind1.getGene(listaIndices.get(i));
            ind1.setGene(listaIndices.get(i), ind2.getGene(listaIndices.get(i)));
            ind2.setGene(listaIndices.get(i), aux);

        }
        listaIndices.clear();
    }

    @Override
    public String toString(){
        //TODO
        return "Recomb method2";
    }
    private int getIndexOf(int[] vetor, int valor){
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i]==valor){
                return i;
            }
        }
        return -1;
    }


}