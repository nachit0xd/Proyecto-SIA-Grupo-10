public class RequisitosAdicionales{
    private int minAniosExperiencia;
    private String educaciónRequerida;

    //Constructor
    public RequisitosAdicionales(int minAniosExperiencia, String educaciónRequerida){
        this.minAniosExperiencia = minAniosExperiencia;
        this.educaciónRequerida = educaciónRequerida;
    }

    //Setters
    public void setMinAniosExperiencia(int minAniosExperiencia){
        this.minAniosExperiencia = minAniosExperiencia;
    }
    public void setEducaciónRequerida(String educaciónRequerida){
        this.educaciónRequerida = educaciónRequerida;
    }
    //Getters
    public int getMinAniosExperiencia(){
        return minAniosExperiencia;
    }
    public String getEducacionRequerida(){
        return educaciónRequerida;
    }
}