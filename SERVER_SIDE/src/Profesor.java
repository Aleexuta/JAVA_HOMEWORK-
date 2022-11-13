public class Profesor implements Human{
    private String nume;
    private String prenume;
    private String acronim;
    private Integer varsta;
    private String materie;

    public Integer getVarsta() {
        return varsta;
    }

    public Profesor(String nume, String prenume, String acronim, Integer varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.materie = materie;
    }

    @Override
    public void greeting() {
        System.out.println("Greetings from Prof. "+nume);
    }

    @Override
    public void doWork() {
        System.out.println("Prof. "+nume+" do work");
    }



    @Override
    public String toString() {
        return "Profesor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", acronim='" + acronim + '\'' +
                ", varsta=" + varsta +
                ", materie='" + materie + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        return varsta.compareTo(o.getVarsta());
    }
}
