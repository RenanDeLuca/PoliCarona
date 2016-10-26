package lunadros.carona;

/**
 * Created by Renan Avila on 06/09/2016.
 */
public class OfertaInfoHolder {

    String Usuario, idUsuario, horarioCriacao, destino, origem;

    OfertaInfoHolder(String Usuario, String idUsuario, String horarioCriacao, String destino, String origem){
        this.Usuario = Usuario;
        this.idUsuario = idUsuario;
        this.horarioCriacao = horarioCriacao;
        this.destino = destino;
        this.origem = origem;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getHorarioCriacao() {
        return horarioCriacao;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }



}
