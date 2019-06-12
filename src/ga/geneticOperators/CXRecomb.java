package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CXRecomb<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {
    I c1;
    I c2;

    //TODO this class might require the definition of additional methods and/or attributes
    public CXRecomb(double probability) {
        super(probability);
    }
    @Override
    public void recombine(I ind1, I ind2) {
        int aux;
        int indice;
        c1=ind1;
        c2=ind2;
        c1.setGene(0,ind2.getGene(0));
        c2.setGene(0,calculaGene1c2(c1.getGene(0),ind1,ind2));

        System.out.println("Tamanho de ind1:"+ind1.getNumGenes());
        for (int i = 1; i < ind1.getNumGenes(); i++) {

            System.out.println("MITICO C2:"+c2.getGene(i-1));
            System.out.println("Valor de i: "+i);
            aux=c2.getGene(i-1);
            indice=ind1.getIndexof(aux);
            c1.setGene(i,ind2.getGene(indice));
            //-----------------------Fim c1-------------------------//
            aux=c1.getGene(i);
            indice=ind1.getIndexof(aux);
            aux=ind2.getGene(indice);
            c2.setGene(i,aux);
            //---Fim C2---------------------------------------------//
        }
        ind1=c1;
        ind2=c2;
    }

    @Override
    public String toString(){
        //TODO
        return "Recomb method2";
    }
    //
    private int calculaGene1c2(int a,I ind1,I ind2){
        int auxIndice=ind1.getIndexof(a);
        auxIndice=ind2.getGene(auxIndice);
        ind2.getGene(auxIndice);
        return ind2.getGene(auxIndice);
    }

}