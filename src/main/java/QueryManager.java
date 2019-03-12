import baseX.BaseXManager;
import nitrite.NitriteManager;

public class QueryManager {
    private static QueryManager queryManager = new QueryManager();

    private QueryManager() {

    }

    public static QueryManager getInstance() {
        return queryManager;
    }

    public String queryCustomer(String input) {
        String token[] = input.split(":");
        String db = token[0];
        String tag = token[1];
        String function = token[2];
        String value = token[3];

        if (db.equals("XML")) {
            return formatOutputCustomer(BaseXManager.getInstance().executeQueryCustomer(tag, value, function));
        } else if (db.equals("DOC")){
            return NitriteManager.getInstance().executeQueryCustomer(tag, value, function);
        }else if(db.equals("ALL")){
            return formatOutputCustomer(BaseXManager.getInstance().executeQueryCustomer(tag, value, function)) +  NitriteManager.getInstance().executeQueryCustomer(tag, value, function);
        }
        return null;
    }

    public String queryOrder(String input) {
        String token[] = input.split(":");
        String db = token[0];
        String tag = token[1];
        String function = token[2];
        String value = token[3];

        if (db.equals("XML")) {
            return formatOutputOrder(BaseXManager.getInstance().executeQueryOrder(tag, value, function));
        } else if (db.equals("DOC")){
            return NitriteManager.getInstance().executeQueryOrder(tag, value, function);
        }else if(db.equals("ALL")){
            return formatOutputOrder(BaseXManager.getInstance().executeQueryOrder(tag, value, function)) +  NitriteManager.getInstance().executeQueryOrder(tag, value, function);
        }
        return null;
    }

    public String formatOutputCustomer(String input){
        return input.replaceAll("</Customer>\n|<Customer.*>\n","\n").replaceAll("<FullAddress>|</FullAddress>","").replaceAll("</.*>","'").replaceAll("<", "").replaceAll(">","='").replaceAll(" ", "");
    }

    public String formatOutputOrder(String input){
        return input.replaceAll("</Order>\n|<Order>\n","\n").replaceAll("</ShipInfo>\n|<ShipInfo.*>\n","").replaceAll("</.*>","'").replaceAll("<", "").replaceAll(">","='").replaceAll(" ", "");
    }
}
