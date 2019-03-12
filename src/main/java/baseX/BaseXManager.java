package baseX;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.Set;
import org.basex.core.cmd.XQuery;

public class BaseXManager {
    private final Context ctx = new Context();

    private static BaseXManager baseXManager = new BaseXManager();

    private BaseXManager() {
        //Carregar base automaticamente
        this.loadData("CustomersAndOrders.xml");
    }

    public static BaseXManager getInstance() {
        return baseXManager;
    }


    public boolean loadData(String file){
        try {
            System.out.println("Carregando: \"" + file + "\".");

            //Criando o parser
            new Set("parser", "xml").execute(ctx);

            //Criando o banco de dados
            new CreateDB("xmlDatabase", file).execute(ctx);
            return true;

        }catch (BaseXException e){
            return false;
        }
    }
    public String executeQueryOrder(String tag, String value, String function) {
        try {
            String query = null;

            if(function.equals("contains")){
                query = "(for $i in //Root/Orders/Order where contains($i/"+tag+", '"+value+"') return( $i ) )";
            }else if(function.equals("equals")){
                query = "(for $i in //Root/Orders/Order where $i/"+tag+" = '" + value + "' return( $i ))";
            }

            System.out.println(query);
            return new XQuery(query).execute(ctx);
        } catch (BaseXException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String executeQueryCustomer(String tag, String value, String function) {
        try {
            String query = null;

            if(function.equals("contains")){
                 query = "(for $i in //Root/Customers/Customer where contains($i/"+tag+", '"+value+"') return( $i ))";
            }else if(function.equals("equals")){
                 query = "(for $i in //Root/Customers/Customer where $i/"+tag+" = '" + value + "' return( $i ))";
            }

            System.out.println(query);
            return new XQuery(query).execute(ctx);
        } catch (BaseXException e) {
            e.printStackTrace();
            return null;
        }
    }
}
