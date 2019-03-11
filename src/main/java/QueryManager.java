
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
            return BaseXManager.getInstance().executeQueryCustomer(tag, value, function);
        } else if (db.equals("DOC")){

        }else if(db.equals("ALL")){

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
            return BaseXManager.getInstance().executeQueryOrder(tag, value, function);
        } else if (db.equals("DOC")){

        }else if(db.equals("ALL")){

        }
        return null;
    }

}
