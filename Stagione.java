import java.util.Random;

public class Stagione {
    public double irradiazione_media;
    public double irradiazione_max;
    public double irrradiazione_min;
    public double prob_pioggia;
    public double prob_nuvoloso;
    public double prob_sereno;
    public int tramonto;
    public int alba;
    public double maxNuvoloso;
    public double maxPioggia;
    public double maxSereno;

    public Stagione(double irradiazione_media, double irradiazione_max, double irrradiazione_min, int tramonto, int alba, double maxSereno, double maxPioggia, double maxNuvoloso) {
        this.irradiazione_media = irradiazione_media;
        this.irradiazione_max = irradiazione_max;
        this.irrradiazione_min = irrradiazione_min;
        this.tramonto = tramonto;
        this.alba = alba;
        this.maxSereno = maxSereno;
        this.maxPioggia = maxPioggia;
        this.maxNuvoloso = maxNuvoloso;
    }

    public double calcIrradiazione(int oraTotale) {
        int oraDelGiorno = oraTotale % 24;
        Random r = new Random();

        prob_nuvoloso = r.nextDouble(0, maxNuvoloso);
        prob_sereno = r.nextDouble(0, maxSereno);
        prob_pioggia = r.nextDouble(0, maxPioggia);

        double irradiazioneMeteo = irradiazione_media + (prob_sereno - prob_nuvoloso - prob_pioggia);

        double fattore_orario = 0;
        if (oraDelGiorno > alba && oraDelGiorno < tramonto) {
            fattore_orario = Math.sin(Math.PI * (double)(oraDelGiorno - alba) / (tramonto - alba));
        }

        double risultato = irradiazioneMeteo * fattore_orario;
        System.out.println("Ora " + oraTotale + ": " + String.format("%.2f", risultato));
        return risultato;
    }
}