import java.util.*;

public class PackageMetrics {

    SortedMap<String, Set<ClassInfo>> metrics;

    String packageName;

    int countClasses = 0;
    int countInterfaces = 0;
    int countPrivateMethods = 0;
    int countProtectedMethods = 0;
    int countPublicMethods = 0;
    int countHierarchy = 0;
    int countAvgParams = 0;

    private double minPrivateMethods = Double.POSITIVE_INFINITY;
    private double avgPrivateMethods = 0;
    private double maxPrivateMethods = 0;

    private double minProtectedMethods = Double.POSITIVE_INFINITY;
    private double avgProtectedMethods = 0;
    private double maxProtectedMethods = 0;

    private double minPublicMethods  = Double.POSITIVE_INFINITY;
    private double avgPublicMethods = 0;
    private double maxPublicMethods = 0;

    private double minInterfaces  = Double.POSITIVE_INFINITY;
    private double avgInterfaces = 0;
    private double maxInterfaces = 0;

    private double minHierarchy  = Double.POSITIVE_INFINITY;
    private double avgHierarchy = 0;
    private double maxHierarchy = 0;

    private double minAvgParams  = Double.POSITIVE_INFINITY;
    private double avgAvgParams = 0;
    private double maxAvgParams = 0;


    public void setTreeFrom(TreeMap t, String from) {
        this.packageName = from;
        this.metrics = new TreeMap<>();
        this.metrics = t.subMap(from, from + "/");
    }

    public void analyzePackage() {
        Set set = this.metrics.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {

            Map.Entry me = (Map.Entry)i.next();

            Set<ClassInfo> classes = (Set<ClassInfo>) me.getValue();



            for(ClassInfo classInfo : classes) {

                /* MIN */
                if(classInfo.getCountPrivateMethods() < minPrivateMethods) {
                    minPrivateMethods = classInfo.getCountPrivateMethods();
                }
                if(classInfo.getCountProtectedMethods() < minProtectedMethods) {
                    minProtectedMethods = classInfo.getCountProtectedMethods();
                }
                if(classInfo.getCountPublicMethods() < minPublicMethods) {
                    minPublicMethods = classInfo.getCountPublicMethods();
                }
                if(classInfo.getCountInterfaces() < minInterfaces) {
                    minInterfaces = classInfo.getCountInterfaces();
                }
                if(classInfo.getCountHierarchy() < minHierarchy) {
                    minHierarchy = classInfo.getCountHierarchy();
                }
                if(classInfo.getCountAverageParams() < minAvgParams) {
                    minAvgParams = classInfo.getCountAverageParams();
                }

                /* MAX */
                if(classInfo.getCountPrivateMethods() > maxPrivateMethods) {
                    maxPrivateMethods = classInfo.getCountPrivateMethods();
                }
                if(classInfo.getCountProtectedMethods() > maxProtectedMethods) {
                    maxProtectedMethods = classInfo.getCountProtectedMethods();
                }
                if(classInfo.getCountPublicMethods() > maxPublicMethods) {
                    maxPublicMethods = classInfo.getCountPublicMethods();
                }
                if(classInfo.getCountInterfaces() > maxInterfaces) {
                    maxInterfaces = classInfo.getCountInterfaces();
                }
                if(classInfo.getCountHierarchy() > maxHierarchy) {
                    maxHierarchy = classInfo.getCountHierarchy();
                }
                if(classInfo.getCountAverageParams() > maxAvgParams) {
                    maxAvgParams = classInfo.getCountAverageParams();
                }


                countClasses++;

                countInterfaces += classInfo.getCountInterfaces();
                countPrivateMethods += classInfo.getCountPrivateMethods();
                countProtectedMethods += classInfo.getCountProtectedMethods();
                countPublicMethods += classInfo.getCountPublicMethods();
                countHierarchy += classInfo.getCountHierarchy();
                countAvgParams += classInfo.getCountAverageParams();
            }

        }

        this.avgPrivateMethods = (double) countPrivateMethods / this.metrics.size();

        this.avgProtectedMethods = (double) countProtectedMethods / this.metrics.size();
        this.avgPublicMethods = (double) countPublicMethods / this.metrics.size();

        this.avgInterfaces = (double) countInterfaces / this.metrics.size();

        this.avgHierarchy = (double) countHierarchy / this.metrics.size();

        this.avgAvgParams = (double) countAvgParams / this.metrics.size();

    }

    public void printMetrics() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- PackageName: " + this.packageName + " ---").append("\n");
        sb.append("Anzahl Klassen: ").append(this.countClasses).append("\n");
        sb.append("Anzahl privater Methoden: ").append(this.countPrivateMethods).append("\n");
        sb.append("Anzahl protected Methoden: ").append(this.countProtectedMethods).append("\n");
        sb.append("Anzahl public Methoden: ").append(this.countPublicMethods).append("\n");

        sb.append("Anzahl Hierarchie: ").append(this.countHierarchy).append("\n");


        sb.append("Min privater Methoden: ").append(this.minPrivateMethods).append("\n");
        sb.append("Avg privater Methoden: ").append(this.avgPrivateMethods).append("\n");
        sb.append("Max privater Methoden: ").append(this.maxPrivateMethods).append("\n").append("\n");

        sb.append("Min protected Methoden: ").append(this.minProtectedMethods).append("\n");
        sb.append("Avg protected Methoden: ").append(this.avgProtectedMethods).append("\n");
        sb.append("Max protected Methoden: ").append(this.maxProtectedMethods).append("\n").append("\n");

        sb.append("Min public Methoden: ").append(this.minPublicMethods).append("\n");
        sb.append("Avg public Methoden: ").append(this.avgPublicMethods).append("\n");
        sb.append("Max public Methoden: ").append(this.maxPublicMethods).append("\n").append("\n");


        sb.append("Min Interfaces: ").append(this.minInterfaces).append("\n");
        sb.append("Avg Interfaces: ").append(this.avgInterfaces).append("\n");
        sb.append("Max Interfaces: ").append(this.maxInterfaces).append("\n").append("\n");

        sb.append("Min Hierarchie: ").append(this.minHierarchy).append("\n");
        sb.append("Avg Hierarchie: ").append(this.avgHierarchy).append("\n");
        sb.append("Max Hierarchie: ").append(this.maxHierarchy).append("\n").append("\n");

        sb.append("Min AvgParams: ").append(this.minAvgParams).append("\n");
        sb.append("Avg AvgParams: ").append(this.avgAvgParams).append("\n");
        sb.append("Max AvgParams: ").append(this.maxAvgParams).append("\n").append("\n");


        System.out.println(sb.toString());

    }

}
