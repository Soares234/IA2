package catchBox;

import ga.IntVectorIndividual;
public class CatchIndividual extends IntVectorIndividual<CatchProblemForGA, CatchIndividual> {

    public CatchIndividual(CatchProblemForGA problem, int size) {
        super(problem, size);
    }

    public CatchIndividual(CatchIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
   fitness=0;
        //Compute catch ate 1ª posicao
        fitness+=verificaCellsGenoma(problem.getCellCatch(),problem.getCellBoxes().get(genome[0]-1)).getValue();
        //Fim catch ate a 1ª posicao
        //Centro do genoma
        for (int i = 0; i < genome.length-1; i++) {
            fitness+=verificaCellsGenoma(problem.getCellBoxes().get(genome[i]-1),problem.getCellBoxes().get(genome[i+1]-1)).getValue();
        }
        //Fim Centro do  genoma
        //Ultima posicao ate door
        fitness+=verificaCellsGenoma(problem.getDoor(),problem.getCellBoxes().get(genome[genome.length-1]-1)).getValue();
        //Fim ultima posicao ate door


   return fitness;
    }

    public int[] getGenome() {
        return genome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fitness: ");
        sb.append(fitness);
        sb.append("\npath: ");
        for (int i = 0; i <genome.length ; i++) {
            sb.append(genome[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and
     * 0, otherwise.
     */
    @Override
    public int compareTo(CatchIndividual i) {
        return (this.fitness == i.getFitness()) ? 0 : (this.fitness < i.getFitness()) ? 1 : -1;
    }

    @Override
    public CatchIndividual clone() {
        return new CatchIndividual(this);
    }

    public Pair verificaCellsGenoma(Cell celula1,Cell celula2){
        for (Pair pair:problem.getPairs()) {
            if ((pair.getCell1()==celula1 || pair.getCell2()==celula1) && (pair.getCell1()==celula2 || pair.getCell2()==celula2)){
                return pair;
            }
        }
        return null;
    }
}
