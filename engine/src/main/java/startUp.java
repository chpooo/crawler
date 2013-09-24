
import org.archive.crawler.Heritrix;

public class startUp {
    public static void main(String[] args) throws Exception {
        //String[] args={"-a","admin:admin"};
        new Heritrix().instanceMain(args);         
    }
}
