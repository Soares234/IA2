package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Recombination3<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination3(double probability) {
        super(probability);
    }
    int[][] listaVizinhos;
    @Override
    public void recombine(I ind1, I ind2) {
        listaVizinhos=new int[ind1.getNumGenes()][4];

    }
    public void preencheListaVizinhos(I ind1, I ind2){
        for (int i = 0; i < ind1.getNumGenes() ; i++) {
            for (int j = 0; j < 4; j++) {

            }
        }
    }
    @Override
    public String toString(){
        //TODO
        throw new NotImplementedException();
    }    
}