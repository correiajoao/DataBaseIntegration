public class JsonDBManager {

    private static JsonDBManager jsonDBManager = new JsonDBManager();

    private JsonDBManager() {

    }

    public static JsonDBManager getInstance() {
        return jsonDBManager;
    }
}
