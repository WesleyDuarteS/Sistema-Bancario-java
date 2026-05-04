import java.util.ArrayList;
import java.util.List;


public class BancoServico {
    private List<Conta> contas = new ArrayList<>();


    public BancoServico() {
        contas.add(new Conta("wesley","1111","7777","3333",30000));
        contas.add(new Conta("lucas","2222","8888","3333",30000));
        contas.add(new Conta("bruno","3333","9999","3333",30000));
        contas.add(new Conta("sebastiao","4444","4444","3333",30000));
        contas.add(new Conta("nilza","5555","5555","3333",30000));
        contas.add(new Conta("nicolas","6666","6666","3333",30000));

    }

    public  List<Conta> getContas() {
        return contas;
    }



}
