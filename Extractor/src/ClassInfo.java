/**
 * Created by markusspringer on 25.04.16.
 */
public class ClassInfo {

    private int countPrivateMethods;
    private int countProtectedMethods;
    private int countPublicMethods;

    private int countInterfaces;

    private int countHierarchy;

    private float countAverageParams;

    private String className;


    public ClassInfo() {
        this.className = "";

        this.countPrivateMethods = 0;
        this.countProtectedMethods = 0;
        this.countPublicMethods = 0;
        this.countInterfaces = 0;
        this.countHierarchy = 0;
        this.countAverageParams = 0;
    }

    public int getCountPrivateMethods() {
        return countPrivateMethods;
    }

    public void setCountPrivateMethods(int countPrivateMethods) {
        this.countPrivateMethods = countPrivateMethods;
    }

    public int getCountProtectedMethods() {
        return countProtectedMethods;
    }

    public void setCountProtectedMethods(int countProtectedMethods) {
        this.countProtectedMethods = countProtectedMethods;
    }

    public int getCountPublicMethods() {
        return countPublicMethods;
    }

    public void setCountPublicMethods(int countPublicMethods) {
        this.countPublicMethods = countPublicMethods;
    }

    public int getCountInterfaces() {
        return countInterfaces;
    }

    public void setCountInterfaces(int countInterfaces) {
        this.countInterfaces = countInterfaces;
    }

    public int getCountHierarchy() {
        return countHierarchy;
    }

    public void setCountHierarchy(int countHierarchy) {
        this.countHierarchy = countHierarchy;
    }

    public float getCountAverageParams() {
        return countAverageParams;
    }

    public void setCountAverageParams(float countAverageParams) {
        this.countAverageParams = countAverageParams;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    @Override
    public String toString() {
        return "ClassInfo{" +
                " name = " + className +
                ", countPrivateMethods=" + countPrivateMethods +
                ", countProtectedMethods=" + countProtectedMethods +
                ", countPublicMethods=" + countPublicMethods +
                ", countInterfaces=" + countInterfaces +
                ", countHierarchy=" + countHierarchy +
                ", countAverageParams=" + countAverageParams +
                '}';
    }
}
