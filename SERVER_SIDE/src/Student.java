public class Student implements Human{
    private String nume;
    private String prenume;
    private String acronim;
    private Integer varsta;
    private Integer an;

    public Integer getVarsta() {
        return varsta;
    }

    @Override
    public int compareTo(Human o) {
        return varsta.compareTo(o.getVarsta());
    }

    public Student(String nume, String prenume, String acronim, Integer varsta, Integer an) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.an = an;
    }

    @Override
    public void greeting() {
        System.out.println("Gretings from Sd. "+nume );
    }

    @Override
    public void doWork() {
        System.out.println("Sd. "+nume+ "is doing work");
    }



    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", acronim='" + acronim + '\'' +
                ", varsta=" + varsta +
                ", an='" + an + '\'' +
                '}';
    }
}
