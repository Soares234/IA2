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
        System.out.println("Ind1 + Ind2 :"+Arrays.toString(ind1.getGenome())+" "+Arrays.toString(ind2.getGenome()));
        int tamanhoInd = ind1.getNumGenes();
        int[] c1 = new int[ind1.getNumGenes()];
        LinkedList<Integer> listaUsados = new LinkedList<>();
        //Cria 2 ints random de 0 a tamanho max
        int corteInicio = ThreadLocalRandom.current().nextInt(0,tamanhoInd-3);
        int corteFim = ThreadLocalRandom.current().nextInt(corteInicio+2,tamanhoInd-1);
        //Fim 2 random ints
        //Copia corte
        for (int i = corteInicio+1; i < corteFim; i++) {
            c1[i]=ind1.getGene(i);
            listaUsados.add(ind1.getGene(i));
        }
        System.out.println("C1 FIM EXECUÇÃO INICIAL: "+Arrays.toString(c1));
        //Fim copia corte
        //Inicio resto
        System.out.println("Valores na lista usados: "+listaUsados.toString()+"\n"+"Corte in + corte Fim:"+corteInicio+" "+corteFim);
        for (int i = corteFim; i < c1.length ; i++) {
           // System.out.println("I:"+i+"Lista Usados: "+ listaUsados.toString()+"\n C1:"+Arrays.toString(c1));

            if (!listaUsados.contains(ind2.getGene(i))){
                c1=adicionarFilho(c1,ind2.getGene(i));
                listaUsados.add(ind2.getGene(i));
            }

            if (c1[c1.length-1]!=0){
                break;
            }

            if (i==ind1.getNumGenes()-1){
                i=-1;
            }

        }
        System.out.println("c1 FIM FINAL"+Arrays.toString(c1));
        //Fim resto
       // System.out.println("Confirmacao"+Arrays.toString(c1));
        for (int i = 0; i < c1.length ; i++) {
           if  (c1[i]==0){
                System.out.println("WTF");
                System.out.println("Corte Inicio:"+corteInicio+"\n Corte Fim:"+corteFim+"\nC1:"+Arrays.toString(c1)+"\nInd1:"+Arrays.toString(ind1.getGenome())+"\nInd2"+Arrays.toString(ind2.getGenome()));
         }
            ind1.setGene(i,c1[i]);
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