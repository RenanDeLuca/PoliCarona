package lunadros.carona;

/**
 * Created by Renan Avila on 06/09/2016.
 */
public class UserInfoHolder {

    String usuario;
    String nome;
    String senha;

    UserInfoHolder(String usuario, String nome, String senha, String email){
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    String email;

}
