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

            listaVizinhos[i][0]=i+1; //preenche o header da tabela, valores 1-X(depende do tamanho do genethingy)

                //---------------------------------------ZONA CASOS DIFERENTES 1-----------------------------------------------------------------------//
                if (ind1.getIndexof(i) == 0 ){//Se for o 1o elemento do array tem de checkar o 2o e ultimo elemento como vizinho
                    listaVizinhos[i][0]=ind1.getGene(ind1.getNumGenes()-1);//Buscar o ultimo valor
                    if (listaVizinhos[i][0]!=ind1.getGene(1)) {
                        listaVizinhos[i][0 + 1] = ind1.getGene(1);//Se for != do valor que já lá está, mete tbm esse
                    }
                }else {
                    if (ind1.getIndexof(i) == ind1.getNumGenes() - 1) {//Se for o ULTIMO elemento do array tem de checkar o ULTIMO-1 e 10 elemento como vizinho
                        listaVizinhos[i][0] = ind1.getGene(0);
                        if (listaVizinhos[i][0] != ind1.getGene(ind1.getNumGenes() - 1)) {
                            listaVizinhos[i][0 + 1] = ind1.getGene(1);
                        }
                    }else{//Se for normal, ou seja, pelo menos 1 ou ultimo gene-2


                    }
                }
                //---------------------------------------FIM DE ZONA CASOS DIFERENTES 1-----------------------------------------------------------------------//

            }

    }
    @Override
    public String toString(){
        return "EdgeRecomb";
    }    
}