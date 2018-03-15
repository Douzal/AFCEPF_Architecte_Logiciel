package fr.afcepf.ai31.rappels.object;

public class Formateur extends Personne {
    
    public Formateur() {
        }


    public Formateur(int paramId, String paramNom, String paramPrenom) {
        // heritage
        super(paramId, paramNom, paramPrenom);
    }


    @Override
	public String travailler() {
		return new StringBuilder().append(getClass().getSimpleName())
				.append(" travaille dur ").toString();
	}

	@Override
	public double allerEnPause() {
		getLog().debug("le formateur va en pause de façon immédiate");
		return 0;
	}
	
	@Override
	public double manger() {
		getLog().debug(new StringBuilder().append(this.getClass().getSimpleName())
			.append(" mange quand bon lui semble."));
		return 0;
	}
	

}
