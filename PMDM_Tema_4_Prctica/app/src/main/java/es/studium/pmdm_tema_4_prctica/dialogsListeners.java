package es.studium.pmdm_tema_4_prctica;

public interface dialogsListeners
{
    public void dialogNombreAceptarListener();
    public void dialogNombreCancelarListener();
    public void onDataNombre(String nombre);

    public void dialogSexoAceptarListener();
    public void dialogSexoCancelarListener();
    public void onDataSexo(String sexo);

    public void dialogEspecieAceptarListener();
    public void dialogEspecieCancelarListener();
    public void onDataEspecie(String especie);

    public void dialogProfesionAceptarListener();
    public void dialogProfesionCancelarListener();
    public void onDataProfesion(String profesion);

    public void comprobarPoderes();
}
